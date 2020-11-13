package brainRoute;

import java.io.IOException;

public class CLIn {

    String baseOS;

    public CLIn() {
        super();
        this.baseOS = System.getProperty("os.name").toLowerCase();
    }

    public void clearCLI() {

        String OS = this.getOS();

        if (OS == "windows") {

            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (IOException ioe) {
                return;
            } catch (InterruptedException ie) {
                return;
            }

        } else if (OS == "macos" || OS == "unix") {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } else {
            return;
        }

    }

    public String getOS() {

        if (this.baseOS.indexOf("win") >= 0) {
            return "windows";
        } else if (this.baseOS.indexOf("mac") >= 0) {
            return "macos";
        } else if (this.baseOS.indexOf("nix") >= 0 || this.baseOS.indexOf("nux") >= 0) {
            return "unix";
        } else {
            return "unknown";
        }

    }

}
