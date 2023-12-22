package today.edu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class notification {
    public MyAppT obj;
    public boolean place = false;
    public boolean update = false;
    public boolean ready = false;

    public notification(MyAppT iobj){
        super();
        this.obj = iobj;
    }
    @And("I have placed an order")
    public void iHavePlacedAnOrder() {
        place = obj.getInstallation() && obj.getAvailable1() && obj.getAvailable2() && obj.getSubmit();
    }

    @When("the order is confirmed and updates are available")
    public void theOrderIsConfirmedAndUpdatesAreAvailable() {
        update = true;
    }

    @Then("Send email to {string}")
    public void sendEmailTo(String recipient) {
        try {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator(){
                @Override
                protected  PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication("caraccessories1224@gmail.com\n","lprr ivue vbtg rwpk");
                }
            });
            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("caraccessories1224@gmail.com\n"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient,false));
            message.setSubject("Software Engineer");
            message.setText("Car accessories project");
            Transport.send(message);
        }
        catch (MessagingException m){
            m.printStackTrace();
        }
    }

    @When("the request is ready to be assigned to an installer")
    public void theRequestIsReadyToBeAssignedToAnInstaller() {
        ready = true;
    }

}
