package itssmt.taller.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import itssmt.taller.dao.ITClienteDao;
import itssmt.taller.entity.TCliente;
import itssmt.taller.modelo.Cliente;
import itssmt.taller.modelo.GenericResponse;
import itssmt.taller.service.IClienteService;

@Service
public class ClienteService implements IClienteService{
	
	@Autowired
	ITClienteDao clienteDao;

	@Override
	public String save(Cliente cliente) {
		
		TCliente tCliente = new TCliente();
		tCliente.setId(cliente.getIdCliente());
		tCliente.setApellidos(cliente.getApellidos());
		tCliente.setNombre(cliente.getNombre());
		tCliente.setDireccion(cliente.getDireccion());
		tCliente.setTelefono(cliente.getTelefono());
		tCliente.setFRegistro(cliente.getFregistro());
		clienteDao.save(tCliente);
		
		
		
		
		return tCliente==null?"No se pudo guardar el cliente":"Se almaceno el cliente";
	}

	@Override
	public List<Cliente> getAll() {
		
		List<Cliente> listaC = new ArrayList<>();
		
		try {
			
			List<TCliente> lista=clienteDao.findAll();
			
			for(TCliente c: lista) {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(c.getId());
			cliente.setNombre(c.getNombre());
			cliente.setApellidos(c.getApellidos());
			cliente.setDireccion(c.getDireccion());
			cliente.setTelefono(c.getTelefono());
			cliente.setFregistro(c.getFRegistro());
			listaC.add(cliente);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaC;
	}

	@Override
	public ResponseEntity<GenericResponse<Cliente>> buscarPorId(int id) {
		GenericResponse<Cliente> response = new GenericResponse<>();
		
		try {
           TCliente c=clienteDao.findOne(id);
           Cliente cliente= new Cliente();
			
			cliente.setIdCliente(c.getId());
			cliente.setNombre(c.getNombre());
			cliente.setApellidos(c.getApellidos());
			cliente.setDireccion(c.getDireccion());
			cliente.setTelefono(c.getTelefono());
			cliente.setFregistro(c.getFRegistro());
			
			
			response.setCode(200);
			response.setMessage("Correcto");
			response.setResponse(cliente);
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setCode(500);
			response.setMessage("Error inesperado");
			return new ResponseEntity<GenericResponse<Cliente>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
		return new ResponseEntity<GenericResponse<Cliente>>(response, HttpStatus.OK);
	}

}
