package com.express.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.express.dao.UploadDao;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;

@Service
public class UploadServiceImpl implements UploadService {

	private static final String FFMPEG_I_S_VCODEC_COPY_ACODEC_COPY_S = "ffmpeg -i %s -vcodec copy -acodec copy %s";

	Logger logger = LogManager.getLogger(UploadServiceImpl.class);

	@Value("${files.uploadDir}")
	private String fileUploadPath;

	@Value("${files.uploadUrl}")
	private String fileUploadUrl;

	@Autowired
	FFprobe ffprobe;
	@Autowired
	FFMpegService ffmpegService;
	@Autowired
	private UploadDao uploadDao;

	@Autowired
	private ThumbnailService thumbnailService;

	public Map<String, Object> uploadAttachment(MultipartFile file, String description, Integer theme, String name,
			Long session_id) {
		Map<String, Object> result = new HashMap<String, Object>();

		result = uploadFile(file, description, theme, name, session_id);

		return result;
	}

	private final Map<String, Object> uploadFile(MultipartFile multipartFile, String description, Integer theme,
			String name, Long session_id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			logger.info(multipartFile.getOriginalFilename() + "  " + name + " name  "
					+ multipartFile.getOriginalFilename().lastIndexOf('.') + " multipartFile.getOriginalFilename() ");
			final String value = String.valueOf(System.currentTimeMillis());
			final String uploadLocation = fileUploadPath + File.separator + theme + File.separator;
			final String originalFileName = multipartFile.getOriginalFilename().replaceAll(" ", "_");
			final String filePath = value + "_" + name.replaceAll(" ", "")
					+ originalFileName.substring(originalFileName.lastIndexOf('.'));
			final String thumbnail = value + "_" + name.replaceAll(" ", "") + "_" + ".png";

			final File destFile = new File(uploadLocation, filePath);
			final File thumbnailFile = new File(uploadLocation, thumbnail);
			String Mp4Address = "";

			FileUtils.copyToFile(multipartFile.getInputStream(), destFile);

			logger.info("upload info :" + filePath);
			String videoFileabsolutePath = destFile.getAbsolutePath();
			Future<Double> duration = thumbnailService.generateThumbnail(videoFileabsolutePath,
					thumbnailFile.getAbsolutePath());

			final FFmpegProbeResult probeResult = ffprobe.probe(videoFileabsolutePath);
			final String fileName = videoFileabsolutePath
					.substring(videoFileabsolutePath.lastIndexOf(File.separator) + 1);
			String targetFilePath = videoFileabsolutePath.substring(0, videoFileabsolutePath.lastIndexOf(".")) + ".mp4";
			logger.info("Source info :" + videoFileabsolutePath);
			logger.info("Destination info :" + targetFilePath);
			try {
				if (!(videoFileabsolutePath.toLowerCase().endsWith("mp4"))) {
					String videoFileabsolutePathExtCut = videoFileabsolutePath.substring(0,
							videoFileabsolutePath.lastIndexOf("."));

					// ffmpegService.convertToMp4(probeResult,
					// videoFileabsolutePathExtCut);
					Runtime.getRuntime().exec(
							String.format(FFMPEG_I_S_VCODEC_COPY_ACODEC_COPY_S, videoFileabsolutePath, targetFilePath));

					Mp4Address = filePath.substring(0, filePath.lastIndexOf(".")) + ".mp4";

				} else {
					// logger.info("optimizeMp4.bat {} {} " ,fileUploadPath ,
					// fileName );
					// Process optimiizer =
					// Runtime.getRuntime().exec("optimizeMp4.bat
					// "+fileUploadPath+" "+fileName);

					// optimiizer.waitFor();
					// new ProcessBuilder("optimizeMp4.bat",fileUploadPath ,
					// fileName ).start().waitFor();
				}
			} catch (Exception e) {
				logger.error("error converting to mp4 " + e.getMessage(), e);
			}
			final Number videoId = uploadDao.persistFileInfo(filePath, multipartFile.getContentType(), description,
					theme, name, thumbnail, session_id, duration, Mp4Address);
			result.put("file", fileUploadUrl + theme + "/" + filePath);
			// result.put("fileLocation", absolutePath);
			result.put("fileType", multipartFile.getContentType());
			result.put("description", description);
			result.put("theme", theme);
			result.put("thumbnail", fileUploadUrl + theme + "/" + thumbnail);
			result.put("video_id ", videoId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Collection<Map<String, Object>> loadUserVideos(Long session_id, Long theme, Integer pageNo,
			Integer pageSize) {
		// TODO Auto-generated method stub
		return uploadDao.loadUserVideos(session_id, theme, pageNo, pageSize);
	}

}
