package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.AdminHotel;
import co.edu.uniquindio.unitravel.repositorios.AdminHotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdminHotelTest {

    @Autowired
    private AdminHotelRepo adminHotelRepo;

    @Test
    public void registrar()
    {
        AdminHotel adminHotel = new AdminHotel("1010194975444", "Angelica", "angelica@hotmail.com", "123456");
        AdminHotel adminHotelGuardado = adminHotelRepo.save(adminHotel);

        Assertions.assertNotNull(adminHotelGuardado);
    }

    @Test
    public void eliminarUsuarioTest()
    {
        AdminHotel adminHotel = new AdminHotel("1010194975444", "Angelica", "angelica@hotmail.com", "123456");
        AdminHotel adminHotelGuardado = adminHotelRepo.save(adminHotel);

        adminHotelRepo.delete(adminHotelGuardado);

        AdminHotel adminHotelbuscado = adminHotelRepo.findById("1010118570").orElse(null);
        Assertions.assertNull(adminHotelbuscado);
    }

    @Test
    public void actualizarUsuarioTest()
    {
        AdminHotel adminHotel = new AdminHotel("1010194975444", "Angelica", "angelica@hotmail.com", "123456");
        AdminHotel adminHotelGuardado = adminHotelRepo.save(adminHotel);

        adminHotelGuardado.setNombre("Sebas");

        adminHotelRepo.save(adminHotelGuardado);

        AdminHotel adminHotelbuscado = adminHotelRepo.findById("1010194975444").orElse(null);
        Assertions.assertEquals("Sebas", adminHotelbuscado.getNombre());
    }

    @Test
    @Sql("classpath:adminhotel.sql")
    public void listarUsuariosTest()
    {
        List<AdminHotel> lista = adminHotelRepo.findAll();
        System.out.println(lista);
    }


}
