package emailapp;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLMessage;

import java.util.Scanner;

public class Email {
        private String firstName;
        private String lastName;
        private String password;
        private String department;
        private String email;
        private int mailboxCapacity = 500;
        private int defaultPasswordLength = 8;
        private String alternateMail;
        private String companySufix = "company.com";


        // CONSTRUCTOR TO RECEIVE THE FIRST AND LAST NAME
        public Email(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            //System.out.println("Email created: " + this.firstName + " " + this.lastName);
            System.out.println("New Worker : "+ firstName + " " + lastName);

            //CALL A METHOD  ASKING FOR THE DEPARTMENT AND RETURN THE DEPARTMENT
            this.department = setDepartment();
            //System.out.println("Department :"+ this.department);

            //CALL A METHOD THAT RETURN A RANDOM PASSWORD
            this.password = randomPassword(defaultPasswordLength);
            System.out.println("Your password is :" + this.password);

            //COMBINE ELEMENTS TO GENERATE EMAIL
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +"." + companySufix ;
            //System.out.println("Your email is :" + email);
        }

        //ASK FOR THE DEPARTMENT
        public String setDepartment(){
            System.out.println("The department code: \n1 for sale \n2 for development \n3 for accounting \n0 for none \nEnter the department code:  ");
            Scanner in = new Scanner(System.in);
            int depChoice = in.nextInt();
            if(depChoice == 1){
            return "Sales";
            }
            else if(depChoice == 2){
                return "Development";
            }
            else if(depChoice == 3){
                return "Accounting";
            }
            else{
                return "";
            }
        }
        //GENERATE A RANDOM PASSWORD
        private String randomPassword(int length){
            String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$&*";
            char[] password = new char[length];
            for( int i=0; i<length; i++){
                int rand =(int)(Math.random() * passwordSet.length());
                password[i] = passwordSet.charAt(rand);
            }
            return new String(password);
        }
        //SET THE MAIL BOX CAPACITY
        public void setMailboxCapacity(int capacity){
            this.mailboxCapacity = capacity;
        }

        //SET THE ALTERNATE MAIL

        public void setAlternateMail(String altMail){
            this.alternateMail = altMail;
        }

        //CHANGE THE PASSWORD
        public void changePassword( String password){
            this.password = password;
        }

        public int getMailboxCapacity(){
            return mailboxCapacity;
        }
        public String getAlternateMail(){
            return alternateMail;
        }
        public String getPassword(){
            return password;
        }

        public String showInfo(){
            return "DISPLAY NAME : " + firstName + " " + lastName +
                    "\nCOMPANY EMAIL : " + email +
                    "\nMAILBOXCPACITY : " + mailboxCapacity + "mb";
        }

}
