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
        setBackground(Color.LIGHT_GRAY);
        sendButton.setBackground(Color.YELLOW);
        sendButton.setBorder(border);
        sendButton.setPreferredSize(new Dimension(40, 40));

        printField.setEditable(false);
        printField.setPreferredSize(new Dimension(40,70));
        printField.setBackground(Color.LIGHT_GRAY);
        printField.setBorder(border);
        printField.setForeground(Color.magenta);
        printField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        printField.setHorizontalAlignment(JTextField.CENTER);

        sendButton.addActionListener(_ -> {
            try {
                String[] array = new String[8];
                if (fieldPanel.getBg().getSelection() != null
                        && (!fieldPanel.getInputSurname().getText().trim().isEmpty()) && (!fieldPanel.getInputName().getText().trim().isEmpty())
                        && fieldPanel.getYearsComboBox().getActionCommand() != null && fieldPanel.getMonthComboBox().getActionCommand() != null && fieldPanel.getDaysComboBox().getActionCommand() != null
                        && (!fieldPanel.getInputCadastralCode().getText().trim().isEmpty())) {

                    array[0] = fieldPanel.getBg().getSelection().getActionCommand();
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

            } catch (Exception x) {
                printField.setText("something went wrong");
            }
        });

        this.add(fieldPanel, BorderLayout.CENTER);
        this.add(sendButton, BorderLayout.PAGE_END);
        this.add(printField,BorderLayout.PAGE_START);
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        fieldPanel.getInputSurname().grabFocus();  //prende il focus all'inizio
    }

    public static void main(String[] args) throws Exception {
        new WebPage();
    }
}
