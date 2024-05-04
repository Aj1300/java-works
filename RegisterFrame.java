import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegisterFrame extends JFrame implements ActionListener {

    private JTextField nameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private Connection connection;

    public RegisterFrame() {
        // Set up the frame
        setTitle("Register");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        nameField = new JTextField(15);
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        registerButton = new JButton("Register");

        // Add action listener to the register button
        registerButton.addActionListener(this);

        // Set layout
        setLayout(new GridLayout(4, 2));

        // Add components to the frame
        add(nameLabel);
        add(nameField);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // Empty label for spacing
        add(registerButton);

        // Initialize database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String name = nameField.getText();
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            // Validate input fields
            if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // Check if username already exists
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username=?");
                statement.setString(1, username);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Insert new user into the database
                    PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO users (name, username, password) VALUES (?, ?, ?)");
                    insertStatement.setString(1, name);
                    insertStatement.setString(2, username);
                    insertStatement.setString(3, password);
                    int rowsAffected = insertStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        nameField.setText("");
                        usernameField.setText("");
                        passwordField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this, "Registration failed.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    insertStatement.close();
                }
                resultSet.close();
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new RegisterFrame();
        
    }
}
