package views;

import controllers.UsuarioController;

import javax.swing.*;

public class PrincipalView extends JFrame {
    private final UsuarioController controller;
    private JTable tablaUsuarios;

    public PrincipalView(UsuarioController controller) {
        this.controller = controller;
        initUI();
        cargarUsuarios();
    }

    private void cargarUsuarios() {
    }

    private void initUI() {
        setTitle("Administración de Usuarios");
        setSize(800, 600);

        // Implementación completa con:
        // - Tabla de usuarios
        // - Botones CRUD
        // - Lógica de actualización automática
    }
}
