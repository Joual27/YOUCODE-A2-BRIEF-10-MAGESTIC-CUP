package org.youcode.magestic_cup.player;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youcode.magestic_cup.player.DTOs.CreatePlayerDTO;
import org.youcode.magestic_cup.player.interfaces.PlayerService;
import org.youcode.magestic_cup.player.mappers.CreatePlayerDTOToPlayerDocumentMapper;

@AllArgsConstructor
@Service
public class PlayerServiceImp implements PlayerService {

    private final PlayerDAO playerDao;
    private final CreatePlayerDTOToPlayerDocumentMapper createPlayerDTOToPlayerDocumentMapper;

    @Override
    public Player save(CreatePlayerDTO data){
        Player playerToCreate = createPlayerDTOToPlayerDocumentMapper.toDocument(data);
        return playerDao.save(playerToCreate);
    }
}
