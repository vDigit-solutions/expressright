package com.express.service;

import net.bramp.ffmpeg.probe.FFmpegProbeResult;

import org.springframework.stereotype.Service;

public interface FFMpegService {
	public void convertToMp4(FFmpegProbeResult probeResult, String outputFile);
}
