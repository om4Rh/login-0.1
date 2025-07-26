// views/RegistroView.java
package views;

import controllers.UsuarioController;
import models.Usuario;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroView extends JFrame {
    private JTextField txtNombreUsuario;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JPasswordField txtContrasena;
    private JButton btnRegistrar;

    public RegistroView() {
        setTitle("Registro de Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Componentes de la interfaz
        txtNombreUsuario = new JTextField(20);
        txtNombre = new JTextField(20);
        txtApellido = new JTextField(20);
        txtTelefono = new JTextField(20);
        txtCorreo = new JTextField(20);
        txtContrasena = new JPasswordField(20);
        btnRegistrar = new JButton("Registrar");

        add(new JLabel("Nombre de Usuario:"));
        add(txtNombreUsuario);
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Apellido:"));
        add(txtApellido);
        add(new JLabel("Teléfono:"));
        add(txtTelefono);
        add(new JLabel("Correo:"));
        add(txtCorreo);
        add(new JLabel("Contraseña:"));
        add(txtContrasena);
        add(btnRegistrar);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(txtNombreUsuario.getText());
        usuario.setNombre(txtNombre.getText());
        usuario.setApellido(txtApellido.getText());
        usuario.setTelefono(txtTelefono.getText());
        usuario.setCorreo(txtCorreo.getText());
        usuario.setContrasena(new String(txtContrasena.getPassword()));

        UsuarioController controller = new UsuarioController();
        if (controller.registrarUsuario(usuario)) {
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente");
            // Redirigir al login o a la vista principal
            new LoginView().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
