package se.jensen.johan.webapp.ui;

// Interface to control which UI is being used
public interface UI {

    public String prompt(String message);

    public void info(String message);

    public String menu();

}
