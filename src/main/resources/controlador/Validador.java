import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;

import dao.daoUsuario;

/**
 * Servlet implementation class Validador
 */
public class Validador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

        String usuario, password, msg = null;
        int valido = 0;
      //1: recibir parametro
      		usuario = request.getParameter("usuario");
      		password = request.getParameter("password");
      		
      		//2: validar
      		try {
      			if(daoUsuario.validar(usuario, password)<1) {
      				msg = "Usuario y Contraseña correctos";
      				valido= 1;
      			}else {
      				msg = "Revise su Usuario o Contraseña";
      			}
      			
      		} catch (Exception e) {
      			
      			e.printStackTrace();
      		}
      		      		
      		//3: ejecuta logica de Negocio
      		msg = msg.toUpperCase();
      		
      		if (valido > 0) {
      		//4: selccionar proxima vista
      		RequestDispatcher despachador = request.getRequestDispatcher("/main.jsp");
      		
      		//5: preparar los datos para vista seleccionada
      		request.setAttribute("mensaje",msg);
      		
      		//6: despachar
      		despachador.forward(request, response);
      		}
      		else {
      		//4: selccionar proxima vista
          		RequestDispatcher despachador = request.getRequestDispatcher("/mensaje.jsp");
          		
          		//5: preparar los datos para vista seleccionada
          		request.setAttribute("mensaje",msg);
          		
          		//6: despachar
          		despachador.forward(request, response);
      			
      		}
    }

}
