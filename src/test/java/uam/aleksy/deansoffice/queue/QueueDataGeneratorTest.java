package uam.aleksy.deansoffice.queue;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uam.aleksy.deansoffice.applicant.data.Student;
import uam.aleksy.deansoffice.utils.dataGeneration.RandomApplicantFactory;

public class QueueDataGeneratorTest {

    @Test
    public void test() {

        // given
        int numOfEmployees = 4;
        int numOfApplicants = 3;
        QueueDataGenerator queueDataGenerator = getGenerator(numOfEmployees, numOfApplicants);

        // when then
        Assertions.assertEquals(queueDataGenerator.generateApplicants().size(), numOfApplicants);
        Assertions.assertEquals(queueDataGenerator.generateEmployees().size(), numOfEmployees);
    }

    private QueueDataGenerator getGenerator(int numOfEmployees, int numOfApplicants) {
        RandomApplicantFactory applicantFactory = Mockito.mock(RandomApplicantFactory.class);
        Mockito.when(applicantFactory.getRandomApplicant()).thenReturn(new Student());
        return new QueueDataGenerator(applicantFactory, numOfApplicants, numOfEmployees);
    }
}
