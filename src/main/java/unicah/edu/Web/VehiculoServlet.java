package unicah.edu.Web;

import unicah.edu.Dominio.Vehiculo;
import  unicah.edu.Servicio.iVehiculoServicio;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/vehiculos")
public class VehiculoServlet extends  HttpServlet{
    @Inject
    iVehiculoServicio vehiculoServicio;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehiculo> vehiculos = vehiculoServicio.listarVehiculos();
        System.out.println("vehiculos:" + vehiculos);
        request.setAttribute("vehiculos", vehiculos);
        request.getRequestDispatcher("/listadoVehiculos.jsp").forward(request, response);
    }
}
