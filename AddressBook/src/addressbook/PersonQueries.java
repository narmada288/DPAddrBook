package addressbook;

// Fig. 28.31: PersonQueries.java
// PreparedStatements used by the Address Book application
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries 
{
   private static final String URL = "jdbc:derby://localhost:1527/Farm";
   private static final String USERNAME = "app";
   private static final String PASSWORD = "app";

   private Connection connection = null; // manages connection
   private PreparedStatement selectAllPeople = null; 
   private PreparedStatement selectPeopleByVillageName = null; 
   private PreparedStatement selectRecentFarm = null; 
    
   // constructor
   public PersonQueries()
   {
      try 
      {
         connection = 
            DriverManager.getConnection( URL, USERNAME, PASSWORD );

         // create query that selects all entries in Farminfo
         selectAllPeople = 
            connection.prepareStatement( "SELECT * FROM FarmInfo ORDER BY VILLAGE, FARMNAME" );
         
         // create query that selects entries with a specific village name
         selectPeopleByVillageName = connection.prepareStatement( 
            "SELECT * FROM FarmInfo WHERE VILLAGE = ?" );
         
         // selects the most recently registered farm
         selectRecentFarm = connection.prepareStatement( 
            "SELECT * FROM FarmInfo WHERE DATEOFREGISTRATION"
                 + "=(SELECT MAX(DATEOFREGISTRATION) FROM FARMINFO)" );
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
         System.exit( 1 );
      } // end catch
   } // end PersonQueries constructor
   
   // select all of the FarmInfo in the database
   public List< Person > getAllFarms()
   {
      List< Person > results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
         resultSet = selectAllPeople.executeQuery(); 
         results = new ArrayList< Person >();
         
         while ( resultSet.next() )
         {
            results.add( new Person(resultSet.getInt( "ID" ),
                                    resultSet.getString( "FarmName" ),
                                    resultSet.getString( "ContactName" ),
                                    resultSet.getString( "PlotNumber" ),
                                    resultSet.getString( "ContactNumber" ),
                                    resultSet.getString( "StreetName" ),
                                    resultSet.getString( "Village" ),
                                    resultSet.getString( "StateName" ),
                                    resultSet.getString( "PostCode" ),
                                    resultSet.getString( "DateofRegistration" )) );
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      return results;
   } // end method getAllPeople
   
   // select person by village name   
   public List< Person > getPeopleByVillageName( String name )
   {
      List< Person > results = null;
      ResultSet resultSet = null;

      try 
      {
         selectPeopleByVillageName.setString( 1, name ); // specify village name

         // executeQuery returns ResultSet containing matching entries
         resultSet = selectPeopleByVillageName.executeQuery(); 

         results = new ArrayList< Person >();

         while ( resultSet.next() )
         {
            results.add( new Person(resultSet.getInt( "ID" ),
                                    resultSet.getString( "FarmName" ),
                                    resultSet.getString( "ContactName" ),
                                    resultSet.getString( "PlotNumber" ),
                                    resultSet.getString( "ContactNumber" ),
                                    resultSet.getString( "StreetName" ),
                                    resultSet.getString( "Village" ),
                                    resultSet.getString( "StateName" ),
                                    resultSet.getString( "PostCode" ),
                                    resultSet.getString( "DateofRegistration" )) );
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      return results;
   } // end method getPeopleByName
   
   // add an entry
   public List< Person > getRecentFarms()
   {
      List< Person > results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
         resultSet = selectRecentFarm.executeQuery(); 
         results = new ArrayList< Person >();

         while ( resultSet.next() )
         {
            results.add( new Person(resultSet.getInt( "ID" ),
                                    resultSet.getString( "FarmName" ),
                                    resultSet.getString( "ContactName" ),
                                    resultSet.getString( "PlotNumber" ),
                                    resultSet.getString( "ContactNumber" ),
                                    resultSet.getString( "StreetName" ),
                                    resultSet.getString( "Village" ),
                                    resultSet.getString( "StateName" ),
                                    resultSet.getString( "PostCode" ),
                                    resultSet.getString( "DateofRegistration" )) );
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
      } // end catch
      return results;
   } // end method getRecentFarms
   
   // close the database connection
   public void close()
   {
      try 
      {
         connection.close();
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      } // end catch
   } // end method close
} // end class PersonQueries


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

 
