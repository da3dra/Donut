package ua.step.smirnova.tests;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.service.ArtistService;
import ua.step.smirnova.service.ArtistServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =  ArtistServiceImpl.class)
public class ArtistServiceTest {

	//ArtistRepository artistRepository;
	
	@Autowired
	ArtistService artistService;
	
/*    @Before
    public void setUp() {
    	artistRepository = Mockito.mock(ArtistRepository.class);
    	artistService = Mockito.mock(ArtistService.class);
    }
    */
	@Test
	public void whenFindByName_thenReturnArtist() {
	final String username = "username";
	    // given
	  Artist artist = new Artist();
	  artist.setEmail("at@f.r");
	  artist.setPasswordHash("sgsgsg");
	  artist.setUsername(username);
	  artistService.add(artist);
	
	    // when
	   Artist found = artistService.findByUsername(username);
	 
	    // then
	    assertThat(found).isEqualTo(artist);
	}
	
}
