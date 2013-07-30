package addressbook;
// Fig. 28.30: Person.java
// Person class that represents an entry in an address book.
public class Person
{
   private int ID;

   
   private String FarmName;
   private String ContactName;
   private String PlotNumber;
   private String ContactNumber;
   private String StreetName;
   private String  Village;
   private String StateName ;
   private String PostCode ;
   private String DateOfRegistration;
   
   
   

   // no-argument constructor
   public Person()
   {
   } // end no-argument Person constructor

   // constructor
   public Person( int id,String FarmN,String ContactN, String PlotNo,String ContactNo, String StreetN, String  Vill, String StateN, String PostC, String DateOfReg)
   {
        setID( id );
        setFarmName( FarmN); 
        setContactName( ContactN); 
        setPlotNumber( PlotNo );
        setContactNumber( ContactNo );
        setStreetName( StreetN );
        setVillage( Vill );
        setStateName( StateN );
        setPostCode( PostC );
        setDateOfRegistration( DateOfReg);      
   } // end five-argument Person constructor 

   // sets the ID
   private void setID( int id )
   {
      ID = id;
   } // end method setID

   // returns the ID 
   public int getID()
   {
      return ID;
   } // end method getID
   
   // sets the firstName
     
   // sets the ContactName
   private void setContactName( String ContactN )
   {
      ContactName = ContactN;
   } // end method setContactName

   // returns the ContactN name 
   public String getContactName()
   {
      return ContactName;
   } // end method getContactName
   
  // sets the ContactNo number
   private void setContactNumber( String ContactNo )
   {
      ContactNumber = ContactNo;
   } // end method setContactNumber

   // returns the ContactNo number
   public String getContactNumber()
   {
      return ContactNumber;
   } // end method getContactNumber

    private void setPlotNumber(String PlotNo) 
    
    {
        PlotNumber = PlotNo;
    }
    public String getPlotNumber() 
    
    {
        return PlotNumber;
    }
    private void setFarmName(String FarmN) 
    {
        FarmName = FarmN;
    }

    public String getFarmName() 
    {
        return FarmName;
    }
    private void setStreetName(String StreetN) 
    {
       StreetName = StreetN;
    }
    public String getStreetName() 
    {
       return StreetName;
    }

    private void  setVillage(String Vill) 
    {
        Village = Vill;
    }
     public  String  getVillage() 
     {
        return Village;
    }

    private void setStateName(String StateN) 
    {
        StateName = StateN;
    }
    
    public String getStateName() 
    {
       return StateName;
    }
       
    private void setPostCode(String PostC)
    {
       PostCode = PostC;
    }
     public String getPostCode()
     {
      return PostCode;
    }
    private void setDateOfRegistration(String DateOfReg)
    {
       DateOfRegistration = DateOfReg  ;
    }
     public String getDateOfRegistration() 
     {
       return DateOfRegistration; 
     }
} // end class Person



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

 