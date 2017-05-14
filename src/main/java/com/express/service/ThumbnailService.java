package com.express.service;

import java.util.concurrent.Future;

public interface ThumbnailService {

	Future<Double> generateThumbnail(String videoFileabsolutePath, String ThumbnailabsolutePath);
}
