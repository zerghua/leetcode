package leetcode;

import java.io.*;
import java.util.*;
/**
 * Created by HuaZ on 9/11/2017.

 Find problems(problem numbers) not in my summary file, so they can be added.

 53 54 58 59 60 70 77 157 158 170 175 176 177 178 180 181 182 183 184 185           (done)
 186 192 193 194 195 196 197 218 243 244 245 246 247 248 249 250 251 254 255 256    (done)
 259 261 262 265 269 270 271 272 276 277 280 281 285 286 288 291 293 294 296 298    (done)
 302 305 308 311 312 314 315 317 320 321 323 325 327 329 330 332 333 335 339 346    (done)
 348 351 352 353 356 358 359 360 361 362 363 364 366 369 370 391 399 400 403 407    (done)
 408 411 418 420 422 425 426 427 428 429 430 431 432 433 439 440 443 444 445 446    (done)
 449 450 457 458 460 465 466 467 469 470 471 472 473 474 476 477 478 479 480 481    (done)
 482 483 484 485 486 487 488 489 490 491 492 493 494 495 496 497 498 499 500 501    (done)
 502 503 504 505 506 507 508 509 510 511 512 513 514 515 516 517 518 519 520 521    (done)
 522 523 524 525 526 527 528 529 530 531 532 533 534 535 536 537 538 539 540 541    (done)
 542 543 544 545 546 547 548 549 550 551 552 553 554 555 556 557 558 559 560 561    (done)
 562 563 564 565 566 567 568 569 570 571 572 573 574 575 576 577 578 579 580 581    (done)
 582 584 585 586 587 588 589 590 591 592 593 594 595 596 597 598 599 600 601 602    (done)
 603 604 605 606 607 608 609 610 611 612 613 614 615 616 617 618 619 620 621 622    (done)
 623 624 625 626 627 628 629 630 631 632 633 634 635 636 637 638 639 640 641 642    (done)
 643 644 645 646 647 648 649 650 651 652 653 654 655 656 657 658 659 660 661 662    (done)
 663 664 665 666 667 668 669 670 671 672 673 674 675 676                            (done)
 There are 334 not in list

 */
public class A_ParseMyTxtFile {
    public void readFile(File file) throws IOException{
        File dir = new File(".");
        FileInputStream fis = new FileInputStream(dir.getCanonicalPath() + file);

        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        HashSet<Integer> set = new HashSet();
        int lineNum = 0;

        // add number to set
        while ((line = br.readLine()) != null) {
            lineNum++;
            //if(lineNum == 123) System.out.println(line);

            if(line!= null && !line.isEmpty() && (Character.isDigit(line.charAt(0)) || line.charAt(0) == '*')){
                //if(lineNum == 123) System.out.println(line);
                int i = line.charAt(0) == '*' ? 1 : 0 , j = i;
                while(j < line.length()){
                    if(Character.isDigit(line.charAt(j))) j++;
                    else break;
                }
                //if(lineNum == 123) System.out.println("j="+j);
                if(j < line.length()-1 && line.charAt(j) == '.' && !Character.isAlphabetic(line.charAt(j+1))) {
                    //if(lineNum == 123) System.out.println(line.substring(i,j));
                    int num = Integer.parseInt(line.substring(i,j));
                    //if(set.contains(num)) System.out.println("find duplicate: "+ num);
                    set.add(num);
                }
            }
        }
        System.out.println("in summary :" + set.size());  // N534 is not included in algorithms

        // print out numbers not in summary
        int count = 0, max = 676; // there are 601 Algorithm problems on 9/11/2017, 676 total(with SQLs)
        for(int i=1; i<= max; i++){
            if(!set.contains(i)) {
                count++;
                System.out.print(i + " ");
                if(count % 20 == 0) System.out.println();  // format
            }
        }
        System.out.println("\nThere are "+ count + " not in list");

        br.close();
    }

    public static void main(String[] args){
        A_ParseMyTxtFile x = new A_ParseMyTxtFile();
        //System.out.println("Working Directory = " + System.getProperty("user.dir"));

        try {
            x.readFile(new File("\\leetcode\\src\\leetcode\\summary"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
