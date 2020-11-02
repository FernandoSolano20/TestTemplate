package cr.ac.ucenfotec.test.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import cr.ac.ucenfotec.test.web.rest.TestUtil;

public class ProyectAccountTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProyectAccount.class);
        ProyectAccount proyectAccount1 = new ProyectAccount();
        proyectAccount1.setId(1L);
        ProyectAccount proyectAccount2 = new ProyectAccount();
        proyectAccount2.setId(proyectAccount1.getId());
        assertThat(proyectAccount1).isEqualTo(proyectAccount2);
        proyectAccount2.setId(2L);
        assertThat(proyectAccount1).isNotEqualTo(proyectAccount2);
        proyectAccount1.setId(null);
        assertThat(proyectAccount1).isNotEqualTo(proyectAccount2);
    }
}
