package com.express.service;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class FFMpegServiceImpl implements FFMpegService{

	private final static Logger logger = LogManager.getLogger(FFMpegServiceImpl.class);
	@Autowired
	FFmpegExecutor ffmpegExecutor;
	@Autowired
	FFprobe ffprobe;
	
	@Async
	public void convertToMp4(FFmpegProbeResult probeResult, String outputFile) {
		logger.info("Streams count {} {}",probeResult.streams.size(),probeResult.streams);
		logger.info("Streams count {} {}",probeResult.streams.get(0).codec_name,probeResult.streams.get(1).codec_name);
		try {
			FFmpegBuilder builder = new FFmpegBuilder();
			builder.setInput(probeResult);
			builder.addOutput(outputFile+".mp4").setFormat("mp4")        // Format is inferred from filename, or can be set
		    //.setTargetSize(250_000)  // Aim for a 250KB file
		    //.disableSubtitle()       // No subtiles
		    //.setAudioChannels(1)         // Mono audio
		    .setAudioCodec("aac")        // using the aac codec
		    .setAudioSampleRate(48_000)  // at 48KHz
		    .setAudioBitRate(32768)      // at 32 kbit/s

		    .setVideoCodec("libx264")     // Video using x264
		    .setVideoFrameRate(24, 1)     // at 24 frames per second
		    .setVideoBitRate(2500/*probeResult.getStreams().get(0).bit_rate*/)
		    //.setVideoResolution(640, 480) // at 640x480 resolution
		    
		    .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL) // Allow FFmpeg to use experimental specs
		    .done();
			
			

			// Run a one-pass encode
			ffmpegExecutor.createJob(builder, new FFMpegProgressListner(probeResult)).run();

			// Or run a two-pass encode (which is slower at the cost of better quality)
			ffmpegExecutor.createTwoPassJob(builder).run();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
	}
	
	@Async
	public void convertToWebm(FFmpegProbeResult probeResult, String outputFile) {
		FFmpegBuilder builder = new FFmpegBuilder();
		builder.setInput(probeResult);
		builder.addOutput(outputFile+".webm").setFormat("webm")        // Format is inferred from filename, or can be set
	    //.setTargetSize(250_000)  // Aim for a 250KB file
	    //.disableSubtitle()       // No subtiles
	    //.setAudioChannels(1)         // Mono audio
	    .setAudioCodec("libvorbis")        // using the aac codec
	    .setAudioSampleRate(48_000)  // at 48KHz
	    .setAudioBitRate(32768)      // at 32 kbit/s

	    .setVideoCodec("libvpx")     // Video using x264
	    .setVideoFrameRate(24, 1)     // at 24 frames per second
	    .setVideoBitRate(probeResult.getStreams().get(0).bits_per_sample)
	    //.setVideoResolution(640, 480) // at 640x480 resolution

	    .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL) // Allow FFmpeg to use experimental specs
	    .done();
		logger.info("Streams count {} ",probeResult.streams.size());
		

		// Run a one-pass encode
		ffmpegExecutor.createJob(builder, new FFMpegProgressListner(probeResult)).run();

		// Or run a two-pass encode (which is slower at the cost of better quality)
		ffmpegExecutor.createTwoPassJob(builder).run();
		
	}

}
