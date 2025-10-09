package com.sprint.hospital_management.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint.hospital_management.entity.Block;
import com.sprint.hospital_management.repository.BlockRepository;

@Service
public class BlockService {
	@Autowired
	private BlockRepository blockRepository;
	
	public Block addBlock(Block block) {
		return blockRepository.save(block);
	}
	
	public List<Block> getAllBlocks(){
		return blockRepository.findAll();
	}
	
	public Optional<Block> getBlockByCode(Integer blockCode){
		return blockRepository.findById(blockCode);
	}
	public void deleteBlock(Integer blockCode) {
		blockRepository.deleteById(blockCode);
	}
}
