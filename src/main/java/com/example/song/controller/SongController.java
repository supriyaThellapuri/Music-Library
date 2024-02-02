/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.song.controller;

import java.util.*;

import com.example.song.service.SongJpaService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.example.song.model.Song;

@RestController
public class SongController {
    @Autowired
    public SongJpaService songJpaService;

    @GetMapping("/songs")
    public ArrayList<Song> getAllSongs() {
        return songJpaService.getAllSongs();
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song) {
        return songJpaService.addSong(song);
    }

    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable("songId") int songId) {
        return songJpaService.getSongById(songId);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song song) {
        return songJpaService.updateSong(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSongById(@PathVariable("songId") int songId) {
        songJpaService.deleteSong(songId);
    }
}