package com.artists.artists.utilities;

import com.artists.artists.model.Album;
import com.artists.artists.model.Artist;
import com.artists.artists.model.DataRequest;

import java.util.List;


public class Parser {

    public static List<Artist> parseData(DataRequest request) {
        List<Artist> artists = request.getArtists();
        List<Album> albums = request.getAlbums();
        for (Artist artist : artists) {
            for (Album album : albums) {
                if (artist.getId().equals(album.getArtistId())) {
                    artist.getAlbums().add(album);
                }
            }
        }
        return artists;
    }
}
