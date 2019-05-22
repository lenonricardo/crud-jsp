package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.BeanJSP;
import dao.DaoUsuario;

@WebServlet("/salvarUsuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoUsuario daousuario = new DaoUsuario();

	public Usuario() {

		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String acao = request.getParameter("acao");
			String user = request.getParameter("user");

			if (acao.equalsIgnoreCase("delete")) {
				BeanJSP usuario = new BeanJSP();
				usuario.setId(Long.parseLong(user));
				Long id = usuario.getId();

				daousuario.deletar(id);
				RequestDispatcher view = request.getRequestDispatcher("cadastroUsuario.jsp");
				request.setAttribute("usuarios", daousuario.listar());
				view.forward(request, response);
			} else if (acao.equalsIgnoreCase("listar")) {
				daousuario.listar();
				RequestDispatcher view = request.getRequestDispatcher("cadastroUsuario.jsp");
				request.setAttribute("usuarios", daousuario.listar());
				view.forward(request, response);

			} else if (acao.equalsIgnoreCase("editar")) {
				BeanJSP beanjsp = daousuario.consultar(user);
				RequestDispatcher view = request.getRequestDispatcher("cadastroUsuario.jsp");
				request.setAttribute("user", beanjsp);
				view.forward(request, response);
			} else if (acao.equalsIgnoreCase("listartodos")) {
				RequestDispatcher view = request.getRequestDispatcher("cadastroUsuario.jsp");
				request.setAttribute("usuarios", daousuario.listar());
				view.forward(request, response);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao != null && acao.equalsIgnoreCase("reset")) {
			try {
				RequestDispatcher view = request.getRequestDispatcher("cadastroUsuario.jsp");
				request.setAttribute("usuarios", daousuario.listar());
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			String id = request.getParameter("id");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String nome = request.getParameter("nome");

			BeanJSP usuario = new BeanJSP();
			usuario.setId(!id.isEmpty() ? Long.parseLong(id) : null);
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario.setNome(nome);

			try {
				
				if(id==null || id.isEmpty() && !daousuario.validarLogin(login)) {
					request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\"><strong>Atenção! </strong>Usuário já existe com o mesmo login</div>");
				}
				
				if (id == null || id.isEmpty() && daousuario.validarLogin(login)) {

					daousuario.salvar(usuario);
					request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\"><strong>Sucesso! </strong>O usuário foi cadastro!</div>");

				} else if(id!= null && !id.isEmpty()) {
					daousuario.atualizar(usuario);
					request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\"><strong>Sucesso! </strong>Seu cadastro foi alterado!</div>");

				}
				try {
					RequestDispatcher view = request.getRequestDispatcher("cadastroUsuario.jsp");
					request.setAttribute("usuarios", daousuario.listar());
					view.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}
}
