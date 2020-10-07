package repository.entity;

import entity.BankBranch;
import entity.Position;
import repository.base.BaseRepository;

public class PositionRepository extends BaseRepository<Position, Long> {
    private static PositionRepository positionRepository;

    private PositionRepository() {

    }

    public static PositionRepository getPositionRepository() {
        if (positionRepository == null) {
            positionRepository = new PositionRepository();
        }
        return positionRepository;
    }

    @Override
    protected Class<Position> getEntityClass() {
        return Position.class;
    }
}
