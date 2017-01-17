package nightplex.services;


/*
 * Interface for our notifcation custom made service
 * 
 * NightPlex
 * 
 * */

public interface NotificationService {

	void addInfoMessage(String title, String msg);
    void addErrorMessage(String title, String msg);
    void addSuccessMessage(String title, String msg);
    void addWarningMessage(String title, String msg);
    void addAlertBasicMessage(String title, String msg);
    void addAlertSuccessMessage(String title, String msg);
    void addAlertWarningMessage(String title, String msg, String confirmButtonText);
    void addAlertWarningMessageWithText(String title, String msg, String confirmButtonText, String titleYesOption, String messageYesOption,  String titleNoOption, String titleNoMessage);
	
}
