package nightplex.services.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;



/*
 * 
 * Our notification service implementation class.
 * 
 *How it works?: 
 *You will add message to a list through a method. After which it is saved to session.
 * Later it is shown to user and deleted from session after time. 
 *
 * NightPlex..
 * 
 * 
 * */

@Service
public class NotificationServiceImpl implements NotificationService {

    public static final String NOTIFY_MSG_SESSION_KEY = "dfgdf734n34hj534fyy7gf";


    // Session for each user
    @Autowired
    private HttpSession http;

    @Override
    public void addInfoMessage(String title, String msg) {
        addNotificationMessage(NotificationMessageType.INFO, msg, title);

    }

    @Override
    public void addErrorMessage(String title, String msg) {
        addNotificationMessage(NotificationMessageType.ERROR, msg, title);
        // Set the types of messages and tect, title
    }

    @Override
    public void addSuccessMessage(String title, String msg) {
        addNotificationMessage(NotificationMessageType.SUCCESS, msg, title);

    }

    @Override
    public void addWarningMessage(String title, String msg) {
        addNotificationMessage(NotificationMessageType.WARNING, msg, title);

    }

    @Override
    public void addAlertBasicMessage(String title, String msg) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addAlertSuccessMessage(String title, String msg) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addAlertWarningMessage(String title, String msg, String confirmButtonText) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addAlertWarningMessageWithText(String title, String msg, String confirmButtonText,
                                               String titleYesOption, String messageYesOption, String titleNoOption, String titleNoMessage) {
        // TODO Auto-generated method stub

    }

    public enum NotificationMessageType { // ENUM for which type of error I will
        // present!!

        INFO, ERROR, SUCCESS, WARNING
    }

	/*
     *
	 * Create a list, add notifications to the list and save it to the Session.
	 * 
	 */

    private void addNotificationMessage(NotificationMessageType type, String msg, String title) {

        List<NotificationMessage> notifyMessages = (List<NotificationMessage>) http // cast the session to list
                .getAttribute(NOTIFY_MSG_SESSION_KEY);
        if (notifyMessages == null) {

            notifyMessages = new ArrayList<NotificationMessage>(); // if empty create new list

        }
        notifyMessages.add(new NotificationMessage(type, msg, title)); // add the message

        http.setAttribute(NOTIFY_MSG_SESSION_KEY, notifyMessages);

    }

	/*
	 * Class for Notification message itself. With message, title and type
	 * 
	 * 
	 */

    public class NotificationMessage {
        NotificationMessageType type;
        String text;
        String title;

        public NotificationMessage(NotificationMessageType type, String text, String title) {
            this.type = type;
            this.text = text;
            this.title = title;
        }

        public NotificationMessageType getType() {
            return type;
        }

        public String getText() {
            return text;
        }

        public String getTitle() {
            return title;
        }

    }


}
