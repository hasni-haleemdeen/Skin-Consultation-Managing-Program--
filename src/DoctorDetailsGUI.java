import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;



public class DoctorDetailsGUI extends WestminsterSkinConsultationManager implements ActionListener {
    private static String doctorName;
    private static String date;
    private static String time;
    private static int cost;



    private static ArrayList<String> personaldetailsList = new ArrayList<String>();
    private static String[] choices = new String[10];


    private static JFrame frame1;
    private static JFrame frame2;
    private static JFrame frame3;
    private static JFrame frame4;
    private static JFrame frame5;
    private static JFrame warning;


    private static JButton viewDoctorButton = new JButton("View Doctors");
    private static JButton bookDoctorButton = new JButton("Book Doctor");
    private static JButton consultationDetailButton = new JButton("View All Consultation Details");
    private static JButton saveButton = new JButton("Save");
    private static JButton resetButton = new JButton("Reset");
    private static JButton viewButton = new JButton("View Details");
    private static JButton bookButton = new JButton("Book");
    private static JButton backButton = new JButton("Go Back");
    private static JButton backButtontwo = new JButton("Go Back");
    private static JButton exitButton = new JButton("Exit");



    private static JLabel nameLabel = new JLabel("Name");
    private static JLabel surnameLabel = new JLabel("Surname");
    private static JLabel dobLabel = new JLabel("Date of Birth");
    private static JLabel mobileNOLabel = new JLabel("Mobile Number");
    private static JLabel idLabel = new JLabel("ID Number");
    private static JLabel durationLabel = new JLabel("Duration of Consultaion");
    private static JLabel firstConsultationLabel = new JLabel("First Consultation?");

    private static JLabel addNotesLabel = new JLabel("Add Notes");
    private static JLabel headingLabel = new JLabel("BOOK!!!");
    private static JLabel doctorNameLabel = new JLabel("Doctor's Name");
    private static JLabel dateLabel = new JLabel("Date of Consultation");
    private static JLabel timeLabel = new JLabel("Time of Consultation");
    private static JLabel infoOne = new JLabel("Choose the doctor you want to consult with");
    private static JLabel infotwo= new JLabel("Enter the date in 'dd/mm/yyyy' format");
    private static JLabel infothree = new JLabel("Enter the time in 'hh:mm' format");

    private static JLabel headingLabelTwo = new JLabel("BOOKING INFORMATION!");
    private static JLabel nameLabelTwo;
    private static JLabel surnameLabelTwo;
    private static JLabel dobLabelTwo;
    private static JLabel mobileNOLabelTwo;
    private static JLabel idLabelTwo;
    private static JLabel durationLabelTwo;
    private static JLabel costLabel;
    private static JLabel doctorNameLabelTwo;
    private static JLabel dateLabelTwo;
    private static JLabel timeLabelTwo;

    private static JLabel mainHeading = new JLabel("Welcome to");
    private static JLabel mainHeadingTwo = new JLabel("Westminster Skin Consultation Clinic");

    private static JLabel paragraph1 = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit");





    private static JTextField nameText = new JTextField();
    private static JTextField surnameText = new JTextField();
    private static JTextField dobText = new JTextField();
    private static JTextField mobileNoText = new JTextField();
    private static JTextField idText = new JTextField();
    private static JTextField durationText = new JTextField();
    private static JTextField notesText = new JTextField("Add Notes");
    private static JTextField dateText = new JTextField("dd/mm/yyyy");
    private static JTextField timeText = new JTextField("hh:mm");


    private static JOptionPane firstOption = new JOptionPane();
    private static JOptionPane secondOption = new JOptionPane();

    private static JComboBox<String> doctorOption = new JComboBox<String>();


    JTable table;

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    FileWriter fw = new FileWriter("Consultation.txt",true);



    public DoctorDetailsGUI() throws IOException {
        frame1 = new JFrame();
        frame1.getContentPane().setBackground(Color.darkGray);

        mainHeading.setBounds(180,10,200,50);
        mainHeading.setForeground(Color.white);
        mainHeading.setFont(new Font("Poppins",Font.BOLD,20));

        mainHeadingTwo.setBounds(30,70,500,50);
        mainHeadingTwo.setForeground(Color.white);
        mainHeadingTwo.setFont(new Font("Poppins",Font.BOLD,24));

        paragraph1.setBounds(30,120,500,50);
        paragraph1.setForeground(Color.white);
        paragraph1.setFont(new Font("Poppins",Font.BOLD,10));

        viewDoctorButton.setBounds(10,400,200,40);
        viewDoctorButton.setBackground(Color.white);
        viewDoctorButton.setFocusable(false);
        viewDoctorButton.addActionListener(this);

        bookDoctorButton.setBounds(250,400,200,40);
        bookDoctorButton.setBackground(Color.white);
        bookDoctorButton.setFocusable(false);
        bookDoctorButton.addActionListener(this);



        frame1.add(mainHeading);
        frame1.add(mainHeadingTwo);
        frame1.add(paragraph1);
        frame1.add(viewDoctorButton);
        frame1.add(bookDoctorButton);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500,1000);
        frame1.setLayout(null);
        frame1.setVisible(true);


    }

    public void doctorDetails(){
        frame2 = new JFrame();
        frame2.setLayout(new GridLayout(2,2));
        frame2.getContentPane().setBackground(Color.darkGray);



        Object[][] data = new Object[doctorList.size()][6];
        for(int i = 0; i<doctorList.size(); i++){
            data[i][0] = doctorList.get(i).getName();
            data[i][1] = doctorList.get(i).getSurname();
            data[i][2] = doctorList.get(i).getDOB();
            data[i][3] = doctorList.get(i).getNumber();
            data[i][4] = doctorList.get(i).getLicenseNumber();
            data[i][5] = doctorList.get(i).getSpecialisation();
        }


        String[] columns = {"Name", "Surname", "D.O.B", "Mobile No.", "License No.", "Specialisation"};

        table = new JTable(data,columns);
        table.setBounds(0,0,500,600);
        table.setBackground(Color.DARK_GRAY);
        table.setForeground(Color.white);
        panel1.add(new JScrollPane(table));
        panel1.setBounds(0,0,500,600);
        panel1.setBackground(Color.darkGray);


        bookDoctorButton.setBounds(10,250,400,0);
        bookDoctorButton.setBackground(Color.white);
        bookDoctorButton.setPreferredSize(new Dimension(450,50));
        backButton.setBounds(10,300,400,0);
        backButton.setBackground(Color.white);
        backButton.setPreferredSize(new Dimension(450,50));

        panel4.add(bookDoctorButton);
        panel4.add(backButton);
        panel4.setBounds(0,600,500,50);
        panel4.setBackground(Color.darkGray);

        frame2.add(panel1);
        frame2.add(panel4);

        frame2.setSize(500,1000);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);

    }

    public void bookDoctor(){
        frame4 = new JFrame();
        frame4.getContentPane().setBackground(Color.darkGray);
        panel2.setLayout(null);
        panel2.setBackground(Color.darkGray);

        for(int i = 0; i<doctorList.size(); i++){
            String name = doctorList.get(i).getName();
            choices[i] = name;
        }

        doctorOption = new JComboBox((String[]) choices);

        doctorOption.setBounds(180,50,250,25);
        doctorOption.setForeground(Color.black);

        headingLabel.setBounds(180,0,150,25);
        doctorNameLabel.setBounds(10,50,100,25);
        dateLabel.setBounds(10,150,150,25);
        timeLabel.setBounds(10,250,150,25);
        infoOne.setBounds(180,70,250,25);
        infotwo.setBounds(180,170,250,25);
        infothree.setBounds(180,270,250,25);

        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Poppins",Font.BOLD,20));
        doctorNameLabel.setForeground(Color.WHITE);
        dateLabel.setForeground(Color.WHITE);
        timeLabel.setForeground(Color.WHITE);
        infoOne.setForeground(Color.WHITE);
        infotwo.setForeground(Color.WHITE);
        infothree.setForeground(Color.WHITE);

        dateText.setBounds(180,150,250,25);
        timeText.setBounds(180,250,250,25);

        bookButton.setBounds(25,350,180,25);
        bookButton.setBackground(Color.white);
        backButtontwo.setBounds(250,350,180,25);
        backButtontwo.setBackground(Color.white);


        date = String.valueOf(dateText);
        time = String.valueOf(timeText);




        panel2.add(headingLabel);
        panel2.add(doctorNameLabel);
        panel2.add(doctorOption);
        panel2.add(dateLabel);
        panel2.add(timeLabel);
        panel2.add(dateText);
        panel2.add(timeText);
        panel2.add(bookButton);
        panel2.add(backButtontwo);
        panel2.add(infoOne);
        panel2.add(infotwo);
        panel2.add(infothree);

        backButtontwo.addActionListener(this);
        bookButton.addActionListener(this);

        frame4.add(panel2);


        frame4.setSize(500,1000);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(true);

    }


    public void personalDetails(){
        frame3 = new JFrame();
        frame3.getContentPane().setBackground(Color.darkGray);
        panel3.setLayout(null);
        panel3.setBackground(Color.DARK_GRAY);


        nameLabel.setBounds(10,20,120,25);
        surnameLabel.setBounds(10,70,120,25);
        dobLabel.setBounds(10,120,120,25);
        mobileNOLabel.setBounds(10,170,120,25);
        idLabel.setBounds(10,220,120,25);
        durationLabel.setBounds(10,270,150,25);
        firstConsultationLabel.setBounds(10,420,150,25);
        addNotesLabel.setBounds(10,320,120,25);

        nameLabel.setForeground(Color.WHITE);
        surnameLabel.setForeground(Color.WHITE);
        dobLabel.setForeground(Color.WHITE);
        mobileNOLabel.setForeground(Color.WHITE);
        idLabel.setForeground(Color.WHITE);
        durationLabel.setForeground(Color.WHITE);
        firstConsultationLabel.setForeground(Color.WHITE);
        addNotesLabel.setForeground(Color.WHITE);

        nameText.setBounds(235,20,165,25);
        surnameText.setBounds(235,70,165,25);
        dobText.setBounds(235,120,165,25);
        mobileNoText.setBounds(235,170,165,25);
        idText.setBounds(235,220,165,25);
        durationText.setBounds(235,270,165,25);
        notesText.setBounds(235,320,165,25);



        saveButton.setBounds(20,470,150,50);
        saveButton.setBackground(Color.white);
        resetButton.setBounds(250,470,150,50);
        resetButton.setBackground(Color.white);
        viewButton.setBounds(100,530,150,25);

        saveButton.addActionListener(this);
        resetButton.addActionListener(this);

        panel3.add(nameLabel);
        panel3.add(nameText);
        panel3.add(surnameLabel);
        panel3.add(surnameText);
        panel3.add(dobLabel);
        panel3.add(dobText);
        panel3.add(mobileNOLabel);
        panel3.add(mobileNoText);
        panel3.add(idLabel);
        panel3.add(idText);
        panel3.add(durationLabel);
        panel3.add(durationText);
        panel3.add(notesText);
        panel3.add(saveButton);
        panel3.add(resetButton);
        panel3.add(addNotesLabel);
        panel3.add(firstOption);

        frame3.add(panel3);

        frame3.setSize(500,1000);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(true);

    }



    public void viewPersonalDetails(){
        frame5 = new JFrame();
        frame5.getContentPane().setBackground(Color.DARK_GRAY);
        panel5.setLayout(null);
        panel5.setBackground(Color.DARK_GRAY);
        Border blackline = BorderFactory.createLineBorder(Color.black);

        panel5.setBorder(blackline);

        headingLabelTwo.setBounds(80,20,400,50);
        headingLabelTwo.setFont(new Font("Serif", Font.PLAIN, 30));
        headingLabelTwo.setForeground(Color.WHITE);

        nameLabelTwo = new JLabel("Your Name -                                               " +nameText.getText());
        nameLabelTwo.setBounds(20,70,450,50);
        nameLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        nameLabelTwo.setForeground(Color.WHITE);

        surnameLabelTwo = new JLabel("Your Surname -                                     " + surnameText.getText());
        surnameLabelTwo.setBounds(20,130,450,50);
        surnameLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        surnameLabelTwo.setForeground(Color.WHITE);

        dobLabelTwo = new JLabel("Your D.O.B -                                               " + dobText.getText());
        dobLabelTwo.setBounds(20,190,450,50);
        dobLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        dobLabelTwo.setForeground(Color.WHITE);

        mobileNOLabelTwo = new JLabel("Your Mobile Number -                             " + mobileNoText.getText());
        mobileNOLabelTwo.setBounds(20,250,450,50);
        mobileNOLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        mobileNOLabelTwo.setForeground(Color.WHITE);

        idLabelTwo = new JLabel("Your ID Number -                                 " + idText.getText());
        idLabelTwo.setBounds(20,310,450,50);
        idLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        idLabelTwo.setForeground(Color.WHITE);

        durationLabelTwo = new JLabel("Duration of Consultation -                     " + durationText.getText() + " Hours");
        durationLabelTwo.setBounds(20,370,450,50);
        durationLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        durationLabelTwo.setForeground(Color.WHITE);

        costLabel = new JLabel("Total Cost -                                                  " + cost + " Pounds");
        costLabel.setBounds(20,430,450,50);
        costLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        costLabel.setForeground(Color.WHITE);

        doctorNameLabelTwo = new JLabel("Assigned Doctor -                                    " + "Dr. " + doctorName);
        doctorNameLabelTwo.setBounds(20,490,450,50);
        doctorNameLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        doctorNameLabelTwo.setForeground(Color.WHITE);

        dateLabelTwo = new JLabel("Booking Date -                                          "  + dateText.getText());
        dateLabelTwo.setBounds(20,550,450,50);
        dateLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        dateLabelTwo.setForeground(Color.WHITE);

        timeLabelTwo = new JLabel("Booking Time -                                          "  + timeText.getText());
        timeLabelTwo.setBounds(20,610,450,50);
        timeLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        timeLabelTwo.setForeground(Color.WHITE);


        exitButton.setBounds(100,680,200,50);
        exitButton.setBackground(Color.white);
        exitButton.addActionListener(this);

        panel5.add(headingLabelTwo);
        panel5.add(nameLabelTwo);
        panel5.add(surnameLabelTwo);
        panel5.add(dobLabelTwo);
        panel5.add(mobileNOLabelTwo);
        panel5.add(idLabelTwo);
        panel5.add(durationLabelTwo);
        panel5.add(costLabel);
        panel5.add(doctorNameLabelTwo);
        panel5.add(dateLabelTwo);
        panel5.add(timeLabelTwo);
        panel5.add(exitButton);


        frame5.add(panel5);
        frame5.setSize(500,1000);


        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.setVisible(true);
    }

    public void reset(){
        nameText.setText(" ");
        surnameText.setText(" ");
        dobText.setText(" ");
        mobileNoText.setText(" ");;
        idText.setText(" ");
        durationText.setText(" ");
        notesText.setText(" ");

    }

    private void checkAvailability() throws IOException {
        //String text = doctorName + " " + date + " " + time;
        if(checkInTextFile("Consultation.txt", doctorOption.getSelectedItem().toString()+ " " + dateText.getText() + " " + timeText.getText())){
            System.out.println("This slot has been already booked by someone else.. SORRY:(((((");
            warning = new JFrame();
            JOptionPane.showMessageDialog(warning,"This slot has been booked by someone else:(","Alert",JOptionPane.WARNING_MESSAGE);
            Random random = new Random();
            String randomName = choices[random.nextInt(10)];
            doctorName = randomName;
            try{
                fw.write(doctorName + " " + dateText.getText() + " " + timeText.getText() + "\n");
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            secondOption.showMessageDialog(null,"Therefore, Doctor " + randomName + " has been assigned to you with the same date & time","Message",JOptionPane.INFORMATION_MESSAGE);
            secondOption.showMessageDialog(null,"Please Enter your personal details to confirm booking","Message",JOptionPane.INFORMATION_MESSAGE);
            frame4.dispose();
            personalDetails();

        }
        else{
            System.out.println("Booking Successfully Done");
            doctorName = doctorOption.getSelectedItem().toString();
            secondOption.showMessageDialog(null,"Booking Successfully Done","Message",JOptionPane.INFORMATION_MESSAGE);
            secondOption.showMessageDialog(null,"Please Enter your personal details to confirm booking","Message",JOptionPane.INFORMATION_MESSAGE);
            frame4.dispose();
            personalDetails();

            try{
                fw.write(doctorOption.getSelectedItem().toString()+ " " + dateText.getText() + " " + timeText.getText() + "\n");
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    private boolean checkInTextFile(String logFile, String text) {
        try{
            BufferedReader buff=new BufferedReader(new FileReader(logFile));
            String s;
            while((s=buff.readLine())!=null){
                if(s.trim().contains(text)){
                    return true;
                }
            }
            buff.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private void saveConsultationDetails() throws IOException {
        fw = new FileWriter("ConsultationDetails.txt",true);
        try{
            for(int i=0; i<personaldetailsList.size(); i++){
                fw.write(personaldetailsList.get(i) + "\n");
                fw.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void viewAllConsultationDetails() throws FileNotFoundException {
        File file = new File("ConsultationDetails.txt");
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewDoctorButton){
            frame1.dispose();
            doctorDetails();
        }
        else if(e.getSource()==bookDoctorButton){
            frame1.dispose();
            bookDoctor();

        }
        else if(e.getSource()==consultationDetailButton){
            frame1.dispose();
            String password = JOptionPane.showInputDialog("This is only for the admins. Please enter the password if you are an admin:)");
            if(password.equalsIgnoreCase("1234")){
                JOptionPane.showMessageDialog(null,"Password Correct, Check Console for all the details of the entire consultation history.", "Admin",JOptionPane.PLAIN_MESSAGE);
                try {
                    viewAllConsultationDetails();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrect Password entered", "Admin",JOptionPane.WARNING_MESSAGE);
            }


        }
        else if(e.getSource()==saveButton){
            personaldetailsList.add(nameText.getText() + " " + surnameText.getText() + " " +  dobText.getText() + " " +
                    mobileNoText.getText() + " " +  idText.getText() + " " +  durationText.getText() + " " +  notesText.getText() + " " +
                    doctorName + " " +  dateText.getText() + " " +  timeText.getText());
            int consultation = JOptionPane.showConfirmDialog(null, "Is this your first consultation?");
            switch (consultation) {
                case JOptionPane.YES_OPTION:
                    cost = Integer.parseInt(durationText.getText())*15;
                    System.out.println(cost);
                    break;
                case JOptionPane.NO_OPTION:
                    cost = Integer.parseInt(durationText.getText())*25;
                    System.out.println(cost);
                    break;
            }
            firstOption.showMessageDialog(null,"Successfully Saved","Message",JOptionPane.INFORMATION_MESSAGE);
            try {
                saveConsultationDetails();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            frame3.dispose();
            viewPersonalDetails();
        }
        else if(e.getSource()==bookButton){
            try {
                checkAvailability();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getSource()==backButtontwo){
            frame4.dispose();
            doctorDetails();
        }
        else if(e.getSource()==exitButton){
            System.exit(0);

        }
        else if(e.getSource()==resetButton){
            reset();
        }
    }

}
