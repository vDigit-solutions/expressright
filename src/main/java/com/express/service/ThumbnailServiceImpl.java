package com.express.service;

import java.util.concurrent.Future;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;

@Service
public class ThumbnailServiceImpl implements ThumbnailService {

	private final static Logger logger = LogManager.getLogger(ThumbnailServiceImpl.class);
	@Autowired
	FFprobe ffprobe;

	@Override
	@Async
	public Future<Double> generateThumbnail(String videoFileabsolutePath, String ThumbnailabsolutePath) {
		Double durationLong = null;
		try {

			FFmpegProbeResult probeResult = ffprobe.probe(videoFileabsolutePath);
			durationLong = probeResult.getFormat().duration;

			// ClassPathResource resource = new
			// ClassPathResource("thumbnail.bat");
			// logger.info(resource.getPath());
			// logger.info(resource.getFile().getAbsolutePath());
			final ProcessBuilder ThumbnailProcessBuilder = new ProcessBuilder("thumbnail.sh", videoFileabsolutePath,
					ThumbnailabsolutePath, String.valueOf(durationLong / 3));
			final Process ThumbnailProcess = ThumbnailProcessBuilder.start();
			ThumbnailProcess.waitFor();

			logger.info("thumb nail extracted");
		} catch (Exception e) {
			logger.error(" Error While Generating Thumbnail " + e.getMessage(), e);
		}
		return new AsyncResult<Double>(durationLong);
	}

}
