package addressbook;
// Fig. 28.32: AddressBookDisplay.java
// A simple address book
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List; 
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;

public class AddressBookDisplay extends JFrame
{
   private Person currentEntry;
   private PersonQueries personQueries;
   private List< Person > results;   
   private int numberOfEntries = 0;
   private int currentEntryIndex;

   private JButton browseButton;
   private JLabel FarmNameLabel;
   private JTextField FarmNameTextField;
   private JLabel PlotNumberLabel;
   private JTextField PlotNumberTextField;
   private JLabel StreetNameLabel;
   private JTextField StreetNameTextField;
   private JLabel VillageLabel;
   private JTextField VillageTextField;
   private JLabel StateLabel;
   private JTextField StateTextField;
   private JLabel PCodeLabel;
   private JTextField PCodeTextField;

   private JLabel IDLabel;
   private JTextField IDTextField;
   private JTextField indexTextField;
   private JLabel ContactNameLabel;
   private JTextField ContactNameTextField;
   private JTextField maxTextField;
   private JButton nextButton;
   private JLabel ofLabel;
   private JLabel ContactNumberLabel;
   private JTextField ContactNumberTextField;
   private JButton previousButton;
   private JButton queryButton;
   private JLabel queryLabel;
   private JPanel queryPanel;
   private JPanel navigatePanel;
   private JPanel displayPanel;
   private JTextField queryTextField;
   private JButton recentButton;
   private JLabel MsgLabel;
   
   // no-argument constructor
   public AddressBookDisplay()
   {
      super( "CQ Dairy Plant Address Book" ); 
      
      // establish database connection and set up PreparedStatements
      personQueries = new PersonQueries(); 
      
      // create GUI
      navigatePanel = new JPanel();
      previousButton = new JButton();
      indexTextField = new JTextField( 2 );
      ofLabel = new JLabel();
      maxTextField = new JTextField( 2 );
      nextButton = new JButton();
      displayPanel = new JPanel();
      IDLabel = new JLabel();
      IDTextField = new JTextField( 10 );
      MsgLabel = new JLabel();
      
      
      
      PlotNumberLabel = new JLabel();
      PlotNumberTextField = new JTextField( 15 );
      StreetNameLabel = new JLabel();
      StreetNameTextField = new JTextField( 15 ); 
      VillageLabel = new JLabel();
      VillageTextField = new JTextField( 15 );
      StateLabel = new JLabel();
      StateTextField = new JTextField(30);
      PCodeLabel = new JLabel();
      PCodeTextField = new JTextField(10);
      
      ContactNameLabel = new JLabel();
      ContactNameTextField = new JTextField( 30 );
      FarmNameLabel = new JLabel();
      FarmNameTextField = new JTextField( 15 );
      ContactNumberLabel = new JLabel();
      ContactNumberTextField = new JTextField( 30 );
      queryPanel = new JPanel();
      queryLabel = new JLabel();
      queryTextField = new JTextField( 15 );
      queryButton = new JButton();
      browseButton = new JButton();
      recentButton = new JButton();

      setLayout( new FlowLayout( FlowLayout.CENTER, 15, 15 ) );
      setSize( 1000, 400 );
      setResizable( false );

      navigatePanel.setLayout(
         new BoxLayout( navigatePanel, BoxLayout.X_AXIS ) );

      previousButton.setText( "Previous" );
      previousButton.setEnabled( false );
      previousButton.addActionListener(
         new ActionListener()
         {
            @Override
            public void actionPerformed( ActionEvent evt )
            {
               previousButtonActionPerformed( evt );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      navigatePanel.add( previousButton );
      navigatePanel.add( Box.createHorizontalStrut( 10 ) );

      indexTextField.setHorizontalAlignment(
         JTextField.CENTER );
      indexTextField.addActionListener(
         new ActionListener()
         {
            @Override
            public void actionPerformed( ActionEvent evt )
            {
               indexTextFieldActionPerformed( evt );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      navigatePanel.add( indexTextField );
      navigatePanel.add( Box.createHorizontalStrut( 10 ) );

      ofLabel.setText( "of" );
      navigatePanel.add( ofLabel );
      navigatePanel.add( Box.createHorizontalStrut( 10 ) );

      maxTextField.setHorizontalAlignment(
         JTextField.CENTER );
      maxTextField.setEditable( false );
      navigatePanel.add( maxTextField );
      navigatePanel.add( Box.createHorizontalStrut( 10 ) );

      nextButton.setText( "Next" );
      nextButton.setEnabled( false );
      nextButton.addActionListener(
         new ActionListener()
         {
            @Override
            public void actionPerformed( ActionEvent evt )
            {
               nextButtonActionPerformed( evt );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      navigatePanel.add( nextButton );
      add( navigatePanel );

      displayPanel.setLayout( new GridLayout( 10, 3, 2, 2 ) );

      IDLabel.setText( "Address ID:" );
      displayPanel.add( IDLabel );

      IDTextField.setEditable( false );
      displayPanel.add( IDTextField );



      ContactNameLabel.setText( "ContactName:" );
      displayPanel.add( ContactNameLabel );
      displayPanel.add( ContactNameTextField );

      FarmNameLabel.setText( "FarmName:" );
      displayPanel.add( FarmNameLabel );
      displayPanel.add( FarmNameTextField );

      ContactNumberLabel.setText( "ContactNumber :" );
      displayPanel.add( ContactNumberLabel );
      displayPanel.add( ContactNumberTextField );
      
      PlotNumberLabel.setText( "PlotNumber :" );
      displayPanel.add( PlotNumberLabel );
      displayPanel.add( PlotNumberTextField );
      
     StreetNameLabel.setText( "StreetName :" );
      displayPanel.add( StreetNameLabel );
      displayPanel.add( StreetNameTextField );
     
       VillageLabel.setText( "Village :" );
       displayPanel.add( VillageLabel );
       displayPanel.add( VillageTextField );
       
       StateLabel.setText("State: ");
       displayPanel.add(StateLabel);
       displayPanel.add(StateTextField);
       
       PCodeLabel.setText("Post Code: ");
       displayPanel.add(PCodeLabel);
       displayPanel.add(PCodeTextField);
       displayPanel.add(MsgLabel);
      add( displayPanel );
     
      queryPanel.setLayout( 
         new BoxLayout( queryPanel, BoxLayout.X_AXIS) );

      queryPanel.setBorder( BorderFactory.createTitledBorder(
         "Find all farms in a Village" ) );
      queryLabel.setText( "Village Name:" );
      queryPanel.add( Box.createHorizontalStrut( 5 ) );
      queryPanel.add( queryLabel );
      queryPanel.add( Box.createHorizontalStrut( 10 ) );
      queryPanel.add( queryTextField );
      queryPanel.add( Box.createHorizontalStrut( 10 ) );

      queryButton.setText( "Find" );
      queryButton.addActionListener(
         new ActionListener()
         {
            @Override
            public void actionPerformed( ActionEvent evt )
            {
               queryButtonActionPerformed( evt );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      queryPanel.add( queryButton );
      queryPanel.add( Box.createHorizontalStrut( 5 ) );
      add( queryPanel );

      browseButton.setText( "Browse All Farms" );
      browseButton.addActionListener(
         new ActionListener()
         {
            @Override
            public void actionPerformed( ActionEvent evt )
            {
               browseButtonActionPerformed( evt );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      add( browseButton );

      recentButton.setText( "Recently Registered Farms" );
      recentButton.addActionListener(
         new ActionListener()
         {
            @Override
            public void actionPerformed( ActionEvent evt )
            {
               recentButtonActionPerformed( evt );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

	   add( recentButton );

      addWindowListener( 
         new WindowAdapter() 
         {  
            @Override
            public void windowClosing( WindowEvent evt )
            {
               personQueries.close(); // close database connection
               System.exit( 0 );
            } // end method windowClosing
         } // end anonymous inner class
      ); // end call to addWindowListener
	
      setVisible( true );
   } // end no-argument constructor

   // handles call when previousButton is clicked
   private void previousButtonActionPerformed( ActionEvent evt )
   {
      --currentEntryIndex;
      
      if ( currentEntryIndex < 0 )
         currentEntryIndex = numberOfEntries - 1;
      
      indexTextField.setText( "" + ( currentEntryIndex + 1 ) );
      indexTextFieldActionPerformed( evt );  
   } // end method previousButtonActionPerformed

   // handles call when nextButton is clicked
   private void nextButtonActionPerformed( ActionEvent evt ) 
   {
      ++currentEntryIndex;
      
      if ( currentEntryIndex >= numberOfEntries )
         currentEntryIndex = 0;
      
      indexTextField.setText( "" + ( currentEntryIndex + 1 ) );
      indexTextFieldActionPerformed( evt );
   } // end method nextButtonActionPerformed

   // handles call when queryButton is clicked
   private void queryButtonActionPerformed( ActionEvent evt )
   {
       MsgLabel.setText("");
      results = 
      personQueries.getPeopleByVillageName( queryTextField.getText() );
      numberOfEntries = results.size();
      
      if ( numberOfEntries != 0 )
      {
         MsgLabel.setText("Number of Records: " + Integer.toString(numberOfEntries));
         currentEntryIndex = 0;
         currentEntry = results.get( currentEntryIndex );
         IDTextField.setText("" + currentEntry.getID() );
         
         ContactNameTextField.setText( currentEntry.getContactName() );
         FarmNameTextField.setText( currentEntry.getFarmName() );
         ContactNumberTextField.setText( currentEntry.getContactNumber() );
         PlotNumberTextField.setText ( currentEntry.getPlotNumber());
         StreetNameTextField.setText( currentEntry.getStreetName());
         VillageTextField.setText( currentEntry.getVillage());
         StateTextField.setText(currentEntry.getStateName());
         PCodeTextField.setText(currentEntry.getPostCode());
         maxTextField.setText( "" + numberOfEntries );
         indexTextField.setText( "" + ( currentEntryIndex + 1 ) );
         nextButton.setEnabled( true );
         previousButton.setEnabled( true );
      } // end if
      else{
         MsgLabel.setText("**No farms in the specified village!**");
         IDTextField.setText("" );
         ContactNameTextField.setText("");
         FarmNameTextField.setText("");
         ContactNumberTextField.setText( "" );
         PlotNumberTextField.setText ( "");
         StreetNameTextField.setText( "");
         VillageTextField.setText( "");
         StateTextField.setText("");
         PCodeTextField.setText("");
      }
   } // end method queryButtonActionPerformed

   // handles call when a new value is entered in indexTextField
   private void indexTextFieldActionPerformed( ActionEvent evt )
   {
       MsgLabel.setText("");
      currentEntryIndex = 
         ( Integer.parseInt( indexTextField.getText() ) - 1 );
      
      if ( numberOfEntries != 0 && currentEntryIndex < numberOfEntries )
      {
          MsgLabel.setText("Number of Records: " + Integer.toString(numberOfEntries));
         currentEntry = results.get( currentEntryIndex );
         IDTextField.setText("" + currentEntry.getID() );
   
         ContactNameTextField.setText( currentEntry.getContactName() );
         FarmNameTextField.setText( currentEntry.getFarmName() );
         ContactNumberTextField.setText( currentEntry.getContactNumber() );
         PlotNumberTextField.setText ( currentEntry.getPlotNumber());
         StreetNameTextField.setText( currentEntry.getStreetName());
         VillageTextField.setText( currentEntry.getVillage());
         StateTextField.setText(currentEntry.getStateName());
         PCodeTextField.setText(currentEntry.getPostCode());
         maxTextField.setText( "" + numberOfEntries );
         indexTextField.setText( "" + ( currentEntryIndex + 1 ) );
      } // end if
    } // end method indexTextFieldActionPerformed

   // handles call when browseButton is clicked
   private void browseButtonActionPerformed( ActionEvent evt )
   {
       MsgLabel.setText("");
      try
      {
         results = personQueries.getAllFarms();
         numberOfEntries = results.size();
      
         if ( numberOfEntries != 0 )
         {
            MsgLabel.setText("Number of Records: " + Integer.toString(numberOfEntries));
            currentEntryIndex = 0;
            currentEntry = results.get( currentEntryIndex );
            IDTextField.setText("" + currentEntry.getID() );
           
            ContactNameTextField.setText( currentEntry.getContactName() );
            FarmNameTextField.setText( currentEntry.getFarmName() );
            ContactNumberTextField.setText( currentEntry.getContactNumber() );
            PlotNumberTextField.setText ( currentEntry.getPlotNumber());
            StreetNameTextField.setText( currentEntry.getStreetName());
            VillageTextField.setText( currentEntry.getVillage());
            StateTextField.setText(currentEntry.getStateName());
            PCodeTextField.setText(currentEntry.getPostCode());
            maxTextField.setText( "" + numberOfEntries );
            indexTextField.setText( "" + ( currentEntryIndex + 1 ) );
            nextButton.setEnabled( true );
            previousButton.setEnabled( true );
         } // end if
      } // end try
      catch ( Exception e )
      {
         e.printStackTrace();
      } // end catch
   } // end method browseButtonActionPerformed

   // handles call when recentButton is clicked
   private void recentButtonActionPerformed( ActionEvent evt ) 
   {
      MsgLabel.setText("");
      try
      {
         results = personQueries.getRecentFarms();
        numberOfEntries = results.size();
      MsgLabel.setText(Integer.toString(numberOfEntries));
      if ( numberOfEntries != 0 )
      {
         currentEntryIndex = 0;
         currentEntry = results.get( currentEntryIndex );
         IDTextField.setText("" + currentEntry.getID() );
         
         ContactNameTextField.setText( currentEntry.getContactName() );
         FarmNameTextField.setText( currentEntry.getFarmName() );
         ContactNumberTextField.setText( currentEntry.getContactNumber() );
         PlotNumberTextField.setText ( currentEntry.getPlotNumber());
         StreetNameTextField.setText( currentEntry.getStreetName());
         VillageTextField.setText( currentEntry.getVillage());
         StateTextField.setText(currentEntry.getStateName());
         PCodeTextField.setText(currentEntry.getPostCode());
         maxTextField.setText( "" + numberOfEntries );
         indexTextField.setText( "" + ( currentEntryIndex + 1 ) );
         nextButton.setEnabled( true );
         previousButton.setEnabled( true );
      } // end if
      else{
         MsgLabel.setText("**No Farms are added recently**");
         IDTextField.setText("" );
         ContactNameTextField.setText("");
         FarmNameTextField.setText("");
         ContactNumberTextField.setText( "" );
         PlotNumberTextField.setText ( "");
         StreetNameTextField.setText( "");
         VillageTextField.setText( "");
         StateTextField.setText("");
         PCodeTextField.setText("");
      }
      } // end try
      catch ( Exception e )
      {
         e.printStackTrace();
      } // end catch
   } // end method recentButtonActionPerformed
   
   // main method
   public static void main( String args[] )
   {
      new AddressBookDisplay();
   } // end method main
} // end class AddressBookDisplay


/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

 