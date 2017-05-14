package com.express.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.progress.Progress;
import net.bramp.ffmpeg.progress.ProgressListener;

public class FFMpegProgressListner implements ProgressListener {

	public FFmpegProbeResult probeResult;
	
	private static final Logger logger = LogManager.getLogger(FFMpegProgressListner.class);

	public FFMpegProgressListner(FFmpegProbeResult probeResult) {
		super();
		this.probeResult = probeResult;
		duration_us = probeResult.getFormat().duration * 1000000.0;
	}

	// Using the FFmpegProbeResult determine the duraction of the input
	final double duration_us;

	@Override
	public void progress(Progress progress) {
		double percentage = progress.out_time_ms / duration_us;

		logger.info("{} : {}  frame:{} time:{} ms fps:{} speed:{}",probeResult.getFormat().filename,percentage * 100, progress.frame, progress.out_time_ms,
				progress.fps.doubleValue(), progress.speed);
		// Print out interesting information about the progress
		/*System.out.println(String.format(locale,
				"[%.0f%%]  frame:%d time:%d ms fps:%.0f speed:%.2fx",
				percentage * 100, progress.frame, progress.out_time_ms,
				progress.fps.doubleValue(), progress.speed));*/
	}
}