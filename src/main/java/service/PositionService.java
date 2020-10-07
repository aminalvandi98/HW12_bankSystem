package service;

import entity.BankBranch;
import entity.Position;
import repository.entity.PositionRepository;

import java.time.LocalDateTime;
import java.util.List;

public class PositionService {
    private PositionRepository positionRepository;

    public PositionService() {
        positionRepository = PositionRepository.getPositionRepository();
    }

    public void showAllPosition() {
        List<Position> positionList = positionRepository.findAll();
        if (positionList.size() == 0) {
            Position managerPosition = new Position();
            Position employeePosition = new Position();
            managerPosition.setAdministrativePosition("manager");
            employeePosition.setAdministrativePosition("employee");
            positionRepository.insert(managerPosition);
            positionRepository.insert(employeePosition);
            positionList = positionRepository.findAll();
        }
        for (Position p : positionList) {
            System.out.println(p.toString());
        }
    }

    public Position getPositionByID(Long id) {
        return positionRepository.findByID(id);
    }
}
