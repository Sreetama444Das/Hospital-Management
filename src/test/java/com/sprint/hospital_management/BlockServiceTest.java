package com.sprint.hospital_management;

import com.sprint.hospital_management.entity.Block;
import com.sprint.hospital_management.service.BlockService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BlockServiceTest {

    private BlockService blockService;

    @BeforeEach
    public void setup() {
        blockService = mock(BlockService.class);
    }

    @Test
    public void testGetAllBlocks() {
        Block b1 = new Block();
        b1.setBlockCode(1);

        Block b2 = new Block();
        b2.setBlockCode(2);

        when(blockService.getAllBlocks()).thenReturn(Arrays.asList(b1, b2));

        List<Block> result = blockService.getAllBlocks();
        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteBlock() {
        doNothing().when(blockService).deleteBlock(1);

        blockService.deleteBlock(1);
        verify(blockService, times(1)).deleteBlock(1);
    }
}