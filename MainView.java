// views/MainView.java
package views;

import controllers.UsuarioController;
import models.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainView extends JFrame {
    private JTable tablaUsuarios;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnCerrarSesion;

    public MainView() {
        setTitle("Gestión de Usuarios");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tabla de usuarios
        tablaUsuarios = new JTable();
        cargarUsuarios();

        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
        add(scrollPane, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        btnActualizar = new JButton("Actualizar Usuario");
        btnEliminar = new JButton("Eliminar Usuario");
        btnCerrarSesion = new JButton("Cerrar Sesión");

        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCerrarSesion);
        add(panelBotones, BorderLayout.SOUTH);

        // Listeners
        btnActualizar.addActionListener(e -> actualizarUsuario());
        btnEliminar.addActionListener(e -> eliminarUsuario());
        btnCerrarSesion.addActionListener(e -> cerrarSesion());
    }

    private void cargarUsuarios() {
        UsuarioController controller = new UsuarioController();
        List<Usuario> usuarios = controller.obtenerTodosUsuarios();

        String[] columnNames = {"ID", "Usuario", "Nombre", "Apellido", "Teléfono", "Correo", "Fecha Registro"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Usuario usuario : usuarios) {
            Object[] rowData = {
                    usuario.getId(),
                    usuario.getNombreUsuario(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getTelefono(),
                    usuario.getCorreo(),
                    usuario.getFechaRegistro()
            };
            model.addRow(rowData);
        }

        tablaUsuarios.setModel(model);
    }

    private void actualizarUsuario() {
        int selectedRow = tablaUsuarios.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tablaUsuarios.getValueAt(selectedRow, 0);
            // Implementar diálogo de actualización
            JOptionPane.showMessageDialog(this, "Actualizar usuario ID: " + id);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminarUsuario() {
        int selectedRow = tablaUsuarios.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tablaUsuarios.getValueAt(selectedRow, 0);
            UsuarioController controller = new UsuarioController();
            if (controller.eliminarUsuario(id)) {
                JOptionPane.showMessageDialog(this, "Usuario eliminado");
                cargarUsuarios();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void cerrarSesion() {
        new LoginView().setVisible(true);
        dispose();
    }
}
