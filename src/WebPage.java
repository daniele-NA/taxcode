import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WebPage extends JFrame  {
    private final FieldPanel fieldPanel = new FieldPanel();
    private final JButton sendButton = new JButton("Calcola il codice fiscale");
    private final Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    private final JTextField printField =new JTextField(18);

    WebPage() {
        super("https:/www.codicefiscaleonline.com/");
        setLayout(new BorderLayout());

        Color background = new Color(38, 50, 56);
        Color accent = new Color(77, 182, 172);  // teal
        Color borderColor = new Color(0x00ACC1);

        getContentPane().setBackground(background);
        sendButton.setBackground(accent);
        sendButton.setForeground(Color.BLACK);
        sendButton.setFocusPainted(false);
        sendButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        sendButton.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        sendButton.setPreferredSize(new Dimension(60, 40));

        printField.setEditable(false);
        printField.setPreferredSize(new Dimension(40, 70));
        printField.setBackground(background);
        printField.setForeground(new Color(255, 202, 40));
        printField.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        printField.setFont(new Font("SansSerif", Font.BOLD, 32));
        printField.setHorizontalAlignment(JTextField.CENTER);


        sendButton.addActionListener(_ -> {
            try {
                String[] array = new String[8];
                if (fieldPanel.getBg().getSelection() != null
                        && (!fieldPanel.getInputSurname().getText().trim().isEmpty()) && (!fieldPanel.getInputName().getText().trim().isEmpty())
                        && fieldPanel.getYearsComboBox().getActionCommand() != null && fieldPanel.getMonthComboBox().getActionCommand() != null && fieldPanel.getDaysComboBox().getActionCommand() != null
                        && (!fieldPanel.getInputCadastralCode().getText().trim().isEmpty())) {

                    array[0] = fieldPanel.getBg().getSelection().getActionCommand();
                    System.out.println(array[0]);
                    array[1] = fieldPanel.getInputSurname().getText();
                    array[2] = fieldPanel.getInputName().getText();
                    array[3] = (String) fieldPanel.getYearsComboBox().getSelectedItem();
                    array[4] = (String) fieldPanel.getMonthComboBox().getSelectedItem();
                    array[5] = (String) fieldPanel.getDaysComboBox().getSelectedItem();
                    array[6] = fieldPanel.getInputCadastralCode().getText();
                    TaxIdCode cf = new TaxIdCode();
                    printField.setText(cf.build(array));
                    fieldPanel.clear();
                }

            } catch (Exception e) {
                printField.setText("something went wrong");
                e.printStackTrace();
            }
        });


        add(printField, BorderLayout.PAGE_START);
        add(fieldPanel, BorderLayout.CENTER);
        add(sendButton, BorderLayout.PAGE_END);
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        fieldPanel.getInputSurname().grabFocus();
    }


    public static void main(String[] args) throws Exception {
        new WebPage();
    }
}
