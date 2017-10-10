#!/usr/bin/env python
# install psutil,   pip install psutil
import sys,psutil,signal,resource,time
from optparse import OptionParser

def monitorPID(pid):
    try:
        pid = int(pid)
    except Exception, e:
        print("Failed convert pid to int: {0}".format(e))
        sys.exit('Exiting...')

    if psutil.pid_exists(pid):
        while(True):
            p = psutil.Process(pid)
            print("checking pid={0}, {1}".format(pid,p.name()))

            if p.num_fds() > 100:
                print("open fd is: {0}".format(p.num_fds()))
                print("memory usgae of server: {0}".format(psutil.virtual_memory()))
                print("memory usage of daemon: {0}".format(p.memory_info()))
                print("current load of system: {0}".format(psutil.cpu_percent()))
                print("all opened files with fd: {0}".format(p.open_files()))

                #set core file size to unlimited.
                resource.setrlimit(resource.RLIMIT_CORE, (resource.RLIM_INFINITY, resource.RLIM_INFINITY))

                #Generate a coredump of daemon (and its child if needed)"
                print("killing pid={0} with coredump...".format(pid))
                p_children = p.children(recursive=True)
                p.send_signal(signal.SIGQUIT)

                # kill children
                for p_child in p_children:
                    p_child.send_signal(signal.SIGQUIT)

                print("done")
                break;

            time.sleep(10)  #10 seconds
    else:
        print('pid={0} does not exist'.format(pid))


class ParseArguments(object):
    def __init__(self):
        self.parser = OptionParser("usage: %prog pid")
        (self.options, self.args) = self.parser.parse_args()
        if len(self.args) == 0: sys.exit(self.parser.print_help())

def main():
    p = ParseArguments()
    monitorPID(p.args[0])

if __name__=='__main__':
    sys.exit(main())
