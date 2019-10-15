package uk.ac.tees.basic.username;

import uk.ac.tees.basic.username.Customer;
import uk.ac.tees.basic.username.EuropeanInvoice;
import java.io.File;
import org.junit.Test;
import uk.ac.tees.basic.username.Customer;
import uk.ac.tees.basic.username.EuropeanInvoice;
import static org.junit.Assert.*;

/** A unit test to check the European invoicing algorithm. Spaces are irrelevant.
 *
 * Based on work created by Mark Truran </p>
 */
public class EuropeanInvoiceTest {
    
   /**
     * Test of getInvoice method, of class EuropeanInvoice.
     */
    @Test
    public void testGetInvoice() {
        System.out.println("Producing European invoice");
        final int invoiceAmount = 17023;
        final Customer c = new Customer("Siemens", invoiceAmount);
        c.setInvoicingAlgorithm(new EuropeanInvoice());
        String actualOutput = c.getInvoice();
        final File f = new File("actual-european.txt");
        FileUtility.resetFile(f);
        FileUtility.writeFile(f, actualOutput);
        String expectedOutput = FileUtility.readFile(new File("expected-european.txt"));
        //System.out.println(actualOutput);
        //System.out.println(expectedOutput);
        actualOutput = actualOutput.replaceAll("\\s", "");
        expectedOutput = expectedOutput.replaceAll("\\s", "");
        System.out.println(actualOutput);
        System.out.println(expectedOutput);
        assertEquals(actualOutput, expectedOutput);
    }
}