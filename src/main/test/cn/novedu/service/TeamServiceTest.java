package cn.novedu.service;

import cn.novedu.bean.Team;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional()
@ContextConfiguration(locations = {"classpath:application-context.xml", "classpath:spring-mvc.xml"})

public class TeamServiceTest {
    @Autowired
    private TeamService teamService;
    private Logger logger = LoggerFactory.getLogger(TeamServiceTest.class);
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    @Rollback(false)
    public void createTeam11() {
        String id = teamService.createTeam("team1", "no description", "02fd3297f18e11e8973400163e043b02", "56969bc9f18d11e8973400163e043b02");
        logger.debug("team id:" + id);
        assertNotNull(id);
    }

    @Test
    @Rollback(false)
    public void createTeam12() {
        String id = teamService.createTeam("team2", "no description", "02fd3297f18e11e8973400163e043b02", "56c235a2f18d11e8973400163e043b02");
        logger.debug("team id:" + id);
        assertNotNull(id);
    }

    /**
     * not in clazz
     */
    @Test
    public void createTeam01() {
        exception.expect(RuntimeException.class);
        String id = teamService.createTeam("team2", "no description", "b7b709b5f12611e8b5b102004c4f4f", "85d21680d47b46dcb3712359c0d400cc");
    }

    /**
     * already in
     */
    @Test
    public void createTeam02() {
        exception.expect(RuntimeException.class);
        String id = teamService.createTeam("team2", "no description", "b7b709b5f12611e8b5b102004c4f4f50", "85d21680d47b46dcb3712359c0d400cc");
    }

    /**
     * not allowed
     */
    @Test
    public void createTeam03() {
        exception.expect(RuntimeException.class);
        String id = teamService.createTeam("team2", "no description", "dab933a5f12611e8b5b102004c4f4f50", "88428f02863b48a78699c54ed29b40d3 ");
    }

    @Test
    public void getTeams() {
        List<Team> teamList = teamService.getTeams("88428f02863b48a78699c54ed29b40d3", "b7b709b5f12611e8b5b102004c4f4f50");
        for (Team team : teamList) {
            logger.debug(team.getName());
        }
    }
}