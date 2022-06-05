package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import com.dam.view.VInicio;
import com.dam.view.VPrincipal;
import com.dam.persistencia.FarmaciaPersistencia;
import com.dam.model.Usuario;
import com.dam.view.PPedido;
import com.dam.view.PVenta;
import com.dam.view.VCrear;

public class InicioControl implements ActionListener {
	
	private VInicio vInicio;
	private VPrincipal vPrincipal;
	private VCrear vCrear;
	private PPedido pPedido;
	private PVenta pVenta;
	private FarmaciaPersistencia fPersistencia;
	
	public InicioControl(VInicio vInicio, VPrincipal vPrincipal, VCrear vCrear, PPedido pPedido, PVenta pVenta, FarmaciaPersistencia fPersistencia) {
		this.vInicio = vInicio;
		this.vPrincipal = vPrincipal;
		this.vCrear = vCrear;
		this.pPedido = pPedido;
		this.pVenta = pVenta;
		this.fPersistencia = fPersistencia;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		//ArrayList<String> lista = new ArrayList<String>();
		Usuario user = null;
		
		if (ev.getSource() instanceof JButton) {
			if (ev.getActionCommand().equals(VInicio.BTN_INICIAR)) {
				String nombreUsuario = vInicio.getNomUser();
				String contrasena = vInicio.getContrasena();
				
				if (nombreUsuario.trim().isEmpty() || contrasena.trim().isEmpty()) {
					vInicio.mostrarError("Debes rellenar los campos 'Usuario' y  'Password'");
					
				}else {
					user = fPersistencia.validarUsuario(nombreUsuario);
					
					if (user != null) {
						if (contrasena.equals(user.getPassword())) {
							abrirPrincipal();
						}else {
							vInicio.mostrarError("La contraseña introducida no es correcta");
						}
					}else {
						vInicio.mostrarError("El usuario introducido no está registrado");
					}
				}
			}
			else if (ev.getActionCommand().equals(VInicio.BTN_CREAR)) {
				abrirCrear();
			}
			else if (ev.getActionCommand().equals(VCrear.BTN_CREAR)) {
				String usuario = vCrear.getUser();
				String pwd = vCrear.getContrasena();
				String confirPwd = vCrear.getCContrasena();
				if (usuario.trim().isEmpty() || pwd.trim().isEmpty() || confirPwd.trim().isEmpty()) {
					vCrear.mostrarError("Debes rellenar todos los campos");
				}else {
					user = fPersistencia.validarUsuario(usuario);
					if (user == null) {
						boolean b = vCrear.comprobarContrasenas();
						
						if (b == false) {
							int num = fPersistencia.crearUsuarioNuevo(usuario, pwd);
							if (num == 1) {
								vCrear.mostrarMensaje("El nuevo usuario ha sido registrado correctamente");
								crearUsuario();
							}
							
						}else {
							vCrear.mostrarError("La contraseña debe coincidir con el campo 'Confirmar password'");
						}
					}else {
						vCrear.mostrarError("El usuario que está intentando introducir ya está registrado. Por favor, introduzca otro");
					}
						
					
				}
				
				
			}
			else if (ev.getActionCommand().equals(VCrear.BTN_VOLVER)) {
				volverInicio();
			}
			else if (ev.getActionCommand().equals(PVenta.BTN_FILTRAR)) {
				filtrarVenta();
			}
			else if (ev.getActionCommand().equals(PVenta.BTN_ANADIR)) {
				anadir();
			}
			else if (ev.getActionCommand().equals(PVenta.BTN_LIMPIAR)) {
				//pVenta.resetearValores();
			}
			else if (ev.getActionCommand().equals(PVenta.BTN_QUITAR)) {
				quitar();
			}
			else if (ev.getActionCommand().equals(PVenta.BTN_VENTA)) {
				vender();
			}
			else if (ev.getActionCommand().equals(PPedido.BTN_FILTRAR)) {
				filtrarPedido();
			}
			else if (ev.getActionCommand().equals(PPedido.BTN_ANADIR)) {
				anadir();
			}
			else if (ev.getActionCommand().equals(PPedido.BTN_LIMPIAR)) {
				//pPedido.resetearValores();
			}
			else if (ev.getActionCommand().equals(PPedido.BTN_PEDIDO)) {
				pedir();
			}
			else if (ev.getActionCommand().equals(PPedido.BTN_QUITAR)) {
				quitar();
			}
		}
		else if (ev.getSource() instanceof JMenuItem) {
			if (ev.getActionCommand().equals(VPrincipal.MNTM_PEDIDO)) {
				mostrarPedido();
			}
			else if (ev.getActionCommand().equals(VPrincipal.MNTM_VENTA)) {
				mostrarVenta();
			}
			else if (ev.getActionCommand().equals(VPrincipal.MNTM_CERRAR)) {
				vPrincipal.dispose();
				volverInicio();
				vPrincipal.borrarCont();
			}
		}
	}

	private void pedir() {
		
	}

	private void filtrarPedido() {
		
	}

	private void vender() {
		
	}

	private void quitar() {
		
	}

	private void anadir() {
		
	}

	private void filtrarVenta() {
		
	}

	private void mostrarVenta() {
		//pVenta.resetearValores();
		vPrincipal.cargarPanel(pVenta);
	}

	private void mostrarPedido() {
		//pPedido.resetearValores();
		vPrincipal.cargarPanel(pPedido);
	}

	private void crearUsuario() {
		volverInicio();
	}

	private void abrirPrincipal() {
		vInicio.dispose();
		vInicio.limpiarDatos();
		vPrincipal.hacerVisible();
	}

	private void volverInicio() {
		vCrear.dispose();
		vCrear.limpiarDatos();
		vInicio.hacerVisible();
	}

	private void abrirCrear() {
		vInicio.dispose();
		vInicio.limpiarDatos();
		vCrear.hacerVisible();
	}
}
