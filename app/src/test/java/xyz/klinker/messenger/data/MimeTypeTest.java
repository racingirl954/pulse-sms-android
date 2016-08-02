/*
 * Copyright (C) 2016 Jacob Klinker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package xyz.klinker.messenger.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class MimeTypeTest {

    @Test
    public void textPlainSupported() {
        assertTrue(MimeType.isSupported(MimeType.TEXT_PLAIN));
    }

    @Test
    public void textHtmlNotSupported() {
        assertFalse(MimeType.isSupported(MimeType.TEXT_HTML));
    }

    @Test
    public void imageJpegSupported() {
        assertTrue(MimeType.isSupported(MimeType.IMAGE_JPEG));
    }

    @Test
    public void imageBmpSupported() {
        assertTrue(MimeType.isSupported(MimeType.IMAGE_BMP));
    }

    @Test
    public void imageJpgSupported() {
        assertTrue(MimeType.isSupported(MimeType.IMAGE_JPG));
    }

    @Test
    public void imagePngSupported() {
        assertTrue(MimeType.isSupported(MimeType.IMAGE_PNG));
    }

    @Test
    public void imageGifSupported() {
        assertTrue(MimeType.isSupported(MimeType.IMAGE_GIF));
    }

    @Test
    public void videoMpegSupported() {
        assertTrue(MimeType.isSupported(MimeType.VIDEO_MPEG));
    }

    @Test
    public void video3gppSupported() {
        assertTrue(MimeType.isSupported(MimeType.VIDEO_3GPP));
    }

    @Test
    public void videoMp4Supported() {
        assertTrue(MimeType.isSupported(MimeType.VIDEO_MP4));
    }

    @Test
    public void audioMp3Supported() {
        assertTrue(MimeType.isSupported(MimeType.AUDIO_MP3));
    }

    @Test
    public void audioMp4Supported() {
        assertTrue(MimeType.isSupported(MimeType.AUDIO_MP4));
    }

    @Test
    public void audioOggSupported() {
        assertTrue(MimeType.isSupported(MimeType.AUDIO_OGG));
    }

    @Test
    public void audioWavSupported() {
        assertTrue(MimeType.isSupported(MimeType.AUDIO_WAV));
    }

    @Test
    public void isStaticImage() {
        assertTrue(MimeType.isStaticImage(MimeType.IMAGE_BMP));
        assertTrue(MimeType.isStaticImage(MimeType.IMAGE_JPEG));
        assertTrue(MimeType.isStaticImage(MimeType.IMAGE_JPG));
        assertTrue(MimeType.isStaticImage(MimeType.IMAGE_PNG));
        assertFalse(MimeType.isStaticImage(MimeType.TEXT_PLAIN));
        assertFalse(MimeType.isStaticImage(MimeType.IMAGE_GIF));
        assertFalse(MimeType.isStaticImage(MimeType.TEXT_PLAIN));
        assertFalse(MimeType.isStaticImage(MimeType.VIDEO_MP4));
        assertFalse(MimeType.isStaticImage(MimeType.AUDIO_MP4));
    }

    @Test
    public void isVideo() {
        assertTrue(MimeType.isVideo(MimeType.VIDEO_MP4));
        assertTrue(MimeType.isVideo(MimeType.VIDEO_3GPP));
        assertTrue(MimeType.isVideo(MimeType.VIDEO_MPEG));
        assertFalse(MimeType.isVideo(MimeType.IMAGE_JPEG));
        assertFalse(MimeType.isVideo(MimeType.TEXT_PLAIN));
        assertFalse(MimeType.isVideo(MimeType.IMAGE_GIF));
        assertFalse(MimeType.isVideo(MimeType.AUDIO_MP4));
    }

    @Test
    public void isAudio() {
        assertTrue(MimeType.isAudio(MimeType.AUDIO_MP4));
        assertTrue(MimeType.isAudio(MimeType.AUDIO_MP3));
        assertTrue(MimeType.isAudio(MimeType.AUDIO_MP3_2));
        assertTrue(MimeType.isAudio(MimeType.AUDIO_OGG));
        assertTrue(MimeType.isAudio(MimeType.AUDIO_WAV));
        assertFalse(MimeType.isAudio(MimeType.IMAGE_JPEG));
        assertFalse(MimeType.isAudio(MimeType.TEXT_PLAIN));
        assertFalse(MimeType.isAudio(MimeType.IMAGE_GIF));
        assertFalse(MimeType.isAudio(MimeType.VIDEO_MP4));
    }

}