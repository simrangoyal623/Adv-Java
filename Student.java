import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;

/* <applet code="Student.class" width=800 height=800></applet> */

public class Student extends Applet implements ActionListener {
 
	Label l1 = new Label("");

	TextField Name = new TextField();
                   TextField Fathername = new TextField();
                   TextField MName = new TextField();
                   TextField PN = new TextField();
                   TextField em = new TextField();
                   TextField ad = new TextField();
	Choice G = new Choice();
                  //DatePicker dp = new DatePicker();
                   Choice B = new Choice();
                   Choice Dep = new Choice();
                    Choice C = new Choice();


	// CheckboxGroup cbg = new CheckboxGroup();
	// Checkbox cb11 = new Checkbox("", cbg, false); 

	// TextField sub1 = new TextField();
	// TextField sub2 = new TextField();
	// TextField sub3 = new TextField();
	// TextField sub4 = new TextField();
	// TextField sub5 = new TextField();
	// TextField prac1 = new TextField();
	// TextField prac2 = new TextField();

	Button b1 = new Button("Submit");
	int x=150, y=30;		


	public void init(){
		try{

			l1.setBounds(400,500,100,30);
			add(l1);

			//Gender choices
			G.add("Male");
			G.add("Female");
			G.add("Other");

			//blood choices
			B.add("A+");
			B.add("A-");
			B.add("B+");
			B.add("B-");
                                                        B.add("O+");
			B.add("O-");
			B.add("AB+");
			B.add("AB-");
                                                              
                                                       //department choice
                                                         Dep.add("CSE");
			Dep.add("EEE");
			Dep.add("CIVIL");
                                                         Dep.add("MEC");

                                                        
                                                       //COURSE choice
                                                         C.add("C");
			C.add("C++");
			C.add("JAVA");
                                                         C.add("ML");
                                                         C.add("PYTHON");

			setLayout(null);

			Name.setBounds(300+x,165-y,300,25);
			Fathername.setBounds(300+x,215-y,300,25);
                                                        MName.setBounds(300+x,265-y,300,25);
                                                        PN.setBounds(300+x,315-y,300,25);
                                                        em.setBounds(300+x,365-y,300,25);
                                                        ad.setBounds(300+x,415-y,300,25);
			G.setBounds(300+x,465-y,100,20);
                                                         //dp.setTitle("choose date of birth");
                                                        B.setBounds(520+x,465-y,80,20);
                                                          Dep.setBounds(300+x,515-y,100,20);
                                                           C.setBounds(520+x,515-y,80,20);

			//sub1.setBounds(350,310,20,20);
			//sub2.setBounds(350,360,20,20);
			//sub3.setBounds(350,410,20,20);
			//sub4.setBounds(350,460,20,20);
			//sub5.setBounds(350,510,20,20);
			//prac1.setBounds(350,560,20,20);
			//prac2.setBounds(350,610,20,20);

			//cb11.setBounds(350,300,50,50);
			b1.setBounds(380+x,570-y,100,30);

			//ADDING fields to applet
			add(Name);
                                                        add(Fathername);
                                                        add(MName);
                                                        add(PN);
                                                        add(em);
                                                         add(ad);
			add(G);
                                                         //dp.getChildren().add(dp);
			add(B);
			add(Dep);
			//add(sub3);
			//add(sub4);
			//add(sub5);
			//add(prac1);
			//add(prac2);
			//add(cb11);
			add(b1);
			b1.addActionListener(this);

			//JDBC Connection
			//System.out.println("in Try");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("Jdbc:Odbc:feedbackdb"); //dsn name
			Statement st = con.createStatement();

			String sql = "Select * from feedbacks";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				// System.out.println("\n"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)
				// 	+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)
				// 	+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10)+"\t"+rs.getString(11));
				System.out.println("\n"+rs.getString(1)+"\t"+rs.getString(2));
			}
		
		}

		catch(Exception ee){System.out.println(ee);}
	}




	public void actionPerformed(ActionEvent e){
		l1.setText(Name.getText());
	}





	public void paint(Graphics g){
		Font font25B = new Font("SansSerif", Font.BOLD,25);
		g.setFont(font25B);
		g.drawString("Student Registration Form",400,70);

		Font font15 = new Font("SansSerif", Font.PLAIN,15);
		g.setFont(font15);
		//g.drawString("On a scale of 1 to 5, please evaluate your Faculty:",180,70+y);
		g.setColor(Color.RED);
		Font font15B = new Font("SansSerif", Font.BOLD,15);
		g.setFont(font15B);
		//g.drawString("5-Strongly Agree  4-Agree  3-Sometimes  2-Disagree  1-Strongly disagree",180,90+y);

		Font font17 = new Font("SansSerif", Font.PLAIN,17);
		g.setFont(font17);
		g.setColor(Color.BLACK);
		g.drawString("Name",180+x,120+y);
		g.drawString("Father's name",180+x,170+y);
g.drawString("Mother's Name",180+x,220+y);
g.drawString("Phone no.",180+x,270+y);
g.drawString("Email",180+x,320+y);
g.drawString("Address",180+x,370+y);
g.drawString("Gender",180+x,420+y);
//Scene sc = new Scene(dp,180,450+y);
//dp.setScene(sc);
//dp.show();
g.drawString("Blood Group",426+x,420+y);
g.drawString("Department",180+x,470+y);

		Font font18 = new Font("SansSerif", Font.PLAIN,17);
		g.setFont(font18);
		//g.drawString("Type a No. between 1 to 5 -",180,250+y);
		// g.drawString("1",350,250+y);
		// g.drawString("2",400,250+y);
		// g.drawString("3",450,250+y);
		// g.drawString("4",500,250+y);
		// g.drawString("5",550,250+y);

		//g.drawString("SUB1",180,300+y);
		//g.drawString("SUB2",180,350+y);
		//g.drawString("SUB3",180,400+y);
		//g.drawString("SUB4",180,450+y);
		//g.drawString("SUB5",180,500+y);
		//g.drawString("PRAC1",180,550+y);
		//g.drawString("PRAC2",180,600+y);
	}

}
