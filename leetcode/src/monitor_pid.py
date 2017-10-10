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
















"Write a working script program in python 2.7 that periodically monitors a specific daemon by its PID (given as script argument). If the daemon has more than 100 opened files descriptors at same time, program does the following actions:

•   Print memory usage of server

•   Print memory usage of daemon

•   Print current load of system

•   Print the list of all opened files in daemon (with corresponding file descriptor)

•   Generate a coredump of daemon (and its child if needed)"


you are allowed to google for useful open source library. You are also allowed to use python interpreter to test your code. We are looking for structured/modular/OO code. Do you think if you can make improvement?




import os,subprocess,time
def run_cmd(cmd):
    p = subprocess.Popen([cmd], stdout=subprocess.PIPE,stderr=subprocess.PIPE, shell=True)
    out, err = p.communicate()
    return out

def getInfo(pid):
    while True:
        num_of_pid = run_cmd('ls -l /proc/{0}/fd | wc -l'.format(pid))
        if num_of_pid > 100:
            #print memory usage of server
            print(run_cmd('free -h'))

            #Print memory usage of daemon
            print(run_cmd('ps aux | grep {0}'.format(pid)))

            #Print current load of system
            print(run_cmd('uptime'))

            #Print the list of all opened files in daemon (with corresponding file descriptor)
            print(run_cmd('lsof -p {0}'.format(pid)))

            #Generate a coredump of daemon (and its child if needed)"
            run_cmd('ulimit -c unlimited; kill -3 {0}'.format(pid))

        # check every 60 seconds
        time.sleep(60)



# install psutil,   pip install psutil
import psutil, signal,resource

def monitorPID(pid):
if psutil.pid_exists(pid):
    p = psutil.Process(pid)

    # print process name
    p.name()

    if p.num_fds() > 100:
        #print memory usage of server
        psutil.virtual_memory()

        #Print memory usage of daemon
        p.memory_percent()
        p.memory_info()

        #Print current load of system
        psutil.cpu_percent()

        #Print the list of all opened files in daemon (with corresponding file descriptor)
        p.open_files()


        #set core file size to unlimited.
        resource.setrlimit(resource.RLIMIT_CORE, (resource.RLIM_INFINITY, resource.RLIM_INFINITY))

        #Generate a coredump of daemon (and its child if needed)"
        p_children = p.children(recursive=True)
        p.send_signal(signal.SIGQUIT)

        # kill children
        for p_child in p_children:
            p_child.send_signal(signal.SIGQUIT)

else:
    print('pid={0} does not exist'.format(pid))




resource.setrlimit(resource.RLIMIT_CORE, (resource.RLIM_INFINITY, resource.RLIM_INFINITY))
resource.getrlimit(resource.RLIMIT_CORE)
resource.getrlimit(resource.RLIMIT_NOFILE)


signal.SIG_DFL

    This is one of two standard signal handling options; it will simply perform the default function for the signal. For example, on most systems the default action for SIGQUIT is to dump core and exit, while the default action for SIGCHLD is to simply ignore it.


ulimit -c unlimited

import psutil, signal
p=psutil.Process(36887)
p.name()
p.send_signal()


p.kill()  # works, but no core dump
p.children(recursive=True)



Then instead of
kill PID
you can use
kill -- -PID
to kill all processes in the group

echo "core" > /proc/sys/kernel/core_pattern
echo "1" > /proc/sys/kernel/core_uses_pid