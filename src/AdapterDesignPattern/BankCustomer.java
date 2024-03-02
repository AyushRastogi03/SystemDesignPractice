package AdapterDesignPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Adapter class
public class BankCustomer extends BankDetails implements CreditCard{
    public void giveBankDetails(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the account holder name : ");
            String customerName  = br.readLine();

            System.out.print("\n");

            System.out.print("Enter the account number:");
            long accno=Long.parseLong(br.readLine());
            System.out.print("\n");

            System.out.print("Enter the bank name :");
            String bankname=br.readLine();

            setAccHolderName(customerName);
            setAccNumber(accno);
            setBankName(bankname);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getCreditCard() {
        long accno=getAccNumber();
        String accholdername=getAccHolderName();
        String bname=getBankName();

        return ("The Account number "+accno+" of "+accholdername+" in "+bname+ "bank is valid and authenticated for issuing the credit card. ");
    }
}
