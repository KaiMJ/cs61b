package gitlet;

import java.io.File;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {

        Repository r = new Repository();
        int inputLength = args.length;
        if (inputLength == 0) {
            System.out.println("Please enter a command.");
        } else {
            switch (args[0]) {
                case "init": {
                    if (inputChecker(1, args)) {
                        r.init();
                    }
                    break;
                }
                case "add": {
                    if (inputChecker(2, args)) {
                        r.add(args[1]);
                    }
                    break;
                }
                case "commit": {
                    if (inputChecker(2, args)) {
                        r.commitment(args[1]);
                    }
                    break;
                }
                case "rm": {
                    if (inputChecker(2, args)) {
                        r.rm(args[1]);
                    }
                    break;
                }
                case "log":
                    if (inputChecker(1, args)) {
                        r.log();
                    }
                    break;
                case "global-log":
                    if (inputChecker(1, args)) {
                        r.global();
                    }
                    break;
                case "find": {
                    r.find(args[1]);
                    break;
                }
                case "status": {
                    if (inputChecker(1, args)) {
                        r.status();
                    }
                    break;
                }
                case "checkout": {
                    if (args.length != 2 && args.length != 3 && args.length != 4) {
                        System.out.println("Incorrect Operands");
                    } else if ((args.length == 4 && !args[2].equals("--"))
                            || (args.length == 3 && !args[1].equals("--"))) {
                        System.out.println("Incorrect Operands");
                    } else {
                        r.checkout(args);
                    }
                    break;
                }
                case "branch": {
                    if (inputChecker(2, args)) {
                        String branchName = args[1];
                        r.branch(branchName);
                    }
                    break;
                }
                case "rm-branch": {
                    if (inputChecker(2, args)) {
                        String branchName = args[1];
                        r.rmb(branchName);
                    }
                    break;
                }
                case "reset": {
                    if (inputChecker(2, args)) {
                        r.reset(args[1]);
                    }
                    break;
                }
                case "merge": {
                    if (inputChecker(2, args)) {
                        r.merge(args[1]);
                    }
                    break;
                }
            }
        }
    }

    static boolean inputChecker(int length, String... args) {
        if (args.length == length) {
            return true;
        }
        System.out.println("Incorrect Operands");
        return false;
    }
}
