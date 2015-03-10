/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2008-2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.gesture;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.graphics.RectF;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.Closeable;
import java.io.IOException;

import static android.gesture.GestureConstants.*;

/**
 * Utility functions for gesture processing & analysis, including methods for:
 * <ul> 
 * <li>feature extraction (e.g., samplers and those for calculating bounding
 * boxes and gesture path lengths);
 * <li>geometric transformation (e.g., translation, rotation and scaling);
 * <li>gesture similarity comparison (e.g., calculating Euclidean or Cosine
 * distances between two gestures).
 * </ul>
 */
public final class GestureUtils {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.094 -0500", hash_original_field = "98F502D6C1A9DC3DA3DE886709668D78", hash_generated_field = "E478F339E61B045FA25E7EFCA197B3F8")
  
    private static final float SCALING_THRESHOLD = 0.26f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.098 -0500", hash_original_field = "F10EED9ECBB6BCDF017A1E5907C40E5A", hash_generated_field = "B257425A0C598244057ABBBF9B63BD37")

    private static final float NONUNIFORM_SCALE = (float) Math.sqrt(2);

    /**
     * Closes the specified stream.
     *
     * @param stream The stream to close.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.104 -0500", hash_original_method = "045AE53A798F87A9B3BAB257E6D245EE", hash_generated_method = "65ED9F602CD521832742D941DC0C4D2D")
    
static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Could not close stream", e);
            }
        }
    }
    
    /**
     * Samples the gesture spatially by rendering the gesture into a 2D 
     * grayscale bitmap. Scales the gesture to fit the size of the bitmap. 
     * The scaling does not necessarily keep the aspect ratio of the gesture. 
     * 
     * @param gesture the gesture to be sampled
     * @param bitmapSize the size of the bitmap
     * @return a bitmapSize x bitmapSize grayscale bitmap that is represented 
     *         as a 1D array. The float at index i represents the grayscale 
     *         value at pixel [i%bitmapSize, i/bitmapSize] 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.109 -0500", hash_original_method = "5F2EA25AC3DD353181FB87C4D2763923", hash_generated_method = "5AC5D4780EE2C7D9F486FE4D8EC21557")
    
public static float[] spatialSampling(Gesture gesture, int bitmapSize) {
        return spatialSampling(gesture, bitmapSize, false);
    }

    /**
     * Samples the gesture spatially by rendering the gesture into a 2D 
     * grayscale bitmap. Scales the gesture to fit the size of the bitmap. 
     * 
     * @param gesture the gesture to be sampled
     * @param bitmapSize the size of the bitmap
     * @param keepAspectRatio if the scaling should keep the gesture's 
     *        aspect ratio
     * 
     * @return a bitmapSize x bitmapSize grayscale bitmap that is represented 
     *         as a 1D array. The float at index i represents the grayscale 
     *         value at pixel [i%bitmapSize, i/bitmapSize] 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.116 -0500", hash_original_method = "421EA5B79C34222DD4C5C9C56863B2BC", hash_generated_method = "C604BD246E5BAABEAB7B3CB2661D06A4")
    
public static float[] spatialSampling(Gesture gesture, int bitmapSize, 
            boolean keepAspectRatio) {
        final float targetPatchSize = bitmapSize - 1; 
        float[] sample = new float[bitmapSize * bitmapSize];
        Arrays.fill(sample, 0);
  
        RectF rect = gesture.getBoundingBox();
        final float gestureWidth = rect.width();
        final float gestureHeight = rect.height();
        float sx = targetPatchSize / gestureWidth;
        float sy = targetPatchSize / gestureHeight;
        
        if (keepAspectRatio) {
            float scale = sx < sy ? sx : sy;
            sx = scale;
            sy = scale;
        } else {

            float aspectRatio = gestureWidth / gestureHeight;
            if (aspectRatio > 1) {
                aspectRatio = 1 / aspectRatio;
            }
            if (aspectRatio < SCALING_THRESHOLD) {
                float scale = sx < sy ? sx : sy;
                sx = scale;
                sy = scale;
            } else {
                if (sx > sy) {
                    float scale = sy * NONUNIFORM_SCALE;
                    if (scale < sx) {
                        sx = scale;
                    }
                } else {
                    float scale = sx * NONUNIFORM_SCALE; 
                    if (scale < sy) {
                        sy = scale;
                    }
                }
            }
        }
        float preDx = -rect.centerX();
        float preDy = -rect.centerY();
        float postDx = targetPatchSize / 2;
        float postDy = targetPatchSize / 2;
        final ArrayList<GestureStroke> strokes = gesture.getStrokes();
        final int count = strokes.size();
        int size;
        float xpos;
        float ypos;
        for (int index = 0; index < count; index++) {
            final GestureStroke stroke = strokes.get(index);
            float[] strokepoints = stroke.points;
            size = strokepoints.length;
            final float[] pts = new float[size];
            for (int i = 0; i < size; i += 2) {
                pts[i] = (strokepoints[i] + preDx) * sx + postDx;
                pts[i + 1] = (strokepoints[i + 1] + preDy) * sy + postDy;
            }
            float segmentEndX = -1;
            float segmentEndY = -1;
            for (int i = 0; i < size; i += 2) {
                float segmentStartX = pts[i] < 0 ? 0 : pts[i];
                float segmentStartY = pts[i + 1] < 0 ? 0 : pts[i + 1];
                if (segmentStartX > targetPatchSize) {
                    segmentStartX = targetPatchSize;
                } 
                if (segmentStartY > targetPatchSize) {
                    segmentStartY = targetPatchSize;
                }
                plot(segmentStartX, segmentStartY, sample, bitmapSize);
                if (segmentEndX != -1) {
                    // Evaluate horizontally
                    if (segmentEndX > segmentStartX) {
                        xpos = (float) Math.ceil(segmentStartX);
                        float slope = (segmentEndY - segmentStartY) / 
                                      (segmentEndX - segmentStartX);
                        while (xpos < segmentEndX) {
                            ypos = slope * (xpos - segmentStartX) + segmentStartY;
                            plot(xpos, ypos, sample, bitmapSize); 
                            xpos++;
                        }
                    } else if (segmentEndX < segmentStartX){
                        xpos = (float) Math.ceil(segmentEndX);
                        float slope = (segmentEndY - segmentStartY) / 
                                      (segmentEndX - segmentStartX);
                        while (xpos < segmentStartX) {
                            ypos = slope * (xpos - segmentStartX) + segmentStartY;
                            plot(xpos, ypos, sample, bitmapSize); 
                            xpos++;
                        }
                    }
                    // Evaluate vertically
                    if (segmentEndY > segmentStartY) {
                        ypos = (float) Math.ceil(segmentStartY);
                        float invertSlope = (segmentEndX - segmentStartX) / 
                                            (segmentEndY - segmentStartY);
                        while (ypos < segmentEndY) {
                            xpos = invertSlope * (ypos - segmentStartY) + segmentStartX;
                            plot(xpos, ypos, sample, bitmapSize); 
                            ypos++;
                        }
                    } else if (segmentEndY < segmentStartY) {
                        ypos = (float) Math.ceil(segmentEndY);
                        float invertSlope = (segmentEndX - segmentStartX) / 
                                            (segmentEndY - segmentStartY);
                        while (ypos < segmentStartY) {
                            xpos = invertSlope * (ypos - segmentStartY) + segmentStartX; 
                            plot(xpos, ypos, sample, bitmapSize); 
                            ypos++;
                        }
                    }
                } 
                segmentEndX = segmentStartX;
                segmentEndY = segmentStartY;
            }
        }
        return sample;
    }
  
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.123 -0500", hash_original_method = "780D94C3D767DD0477F67D4EDF62EEF5", hash_generated_method = "F079AAD3A2391414BF2EA306EB4174E4")
    
private static void plot(float x, float y, float[] sample, int sampleSize) {
        x = x < 0 ? 0 : x;
        y = y < 0 ? 0 : y;
        int xFloor = (int) Math.floor(x);
        int xCeiling = (int) Math.ceil(x);
        int yFloor = (int) Math.floor(y);
        int yCeiling = (int) Math.ceil(y);
        
        // if it's an integer
        if (x == xFloor && y == yFloor) {
            int index = yCeiling * sampleSize + xCeiling;
            if (sample[index] < 1){
                sample[index] = 1;
            }
        } else {
            final double xFloorSq = Math.pow(xFloor - x, 2);
            final double yFloorSq = Math.pow(yFloor - y, 2);
            final double xCeilingSq = Math.pow(xCeiling - x, 2);
            final double yCeilingSq = Math.pow(yCeiling - y, 2);
            float topLeft = (float) Math.sqrt(xFloorSq + yFloorSq);
            float topRight = (float) Math.sqrt(xCeilingSq + yFloorSq);
            float btmLeft = (float) Math.sqrt(xFloorSq + yCeilingSq);
            float btmRight = (float) Math.sqrt(xCeilingSq + yCeilingSq);
            float sum = topLeft + topRight + btmLeft + btmRight;
            
            float value = topLeft / sum;
            int index = yFloor * sampleSize + xFloor;
            if (value > sample[index]){
                sample[index] = value;
            }
            
            value = topRight / sum;
            index = yFloor * sampleSize + xCeiling;
            if (value > sample[index]){
                sample[index] = value;
            }
            
            value = btmLeft / sum;
            index = yCeiling * sampleSize + xFloor;
            if (value > sample[index]){
                sample[index] = value;
            }
            
            value = btmRight / sum;
            index = yCeiling * sampleSize + xCeiling;
            if (value > sample[index]){
                sample[index] = value;
            }
        }
    }

    /**
     * Samples a stroke temporally into a given number of evenly-distributed 
     * points.
     * 
     * @param stroke the gesture stroke to be sampled
     * @param numPoints the number of points
     * @return the sampled points in the form of [x1, y1, x2, y2, ..., xn, yn]
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.128 -0500", hash_original_method = "4CD7AC7DB8F833D7B66F15805AD0D408", hash_generated_method = "03BB236682C09B8F2AC30D9CC9680E56")
    
public static float[] temporalSampling(GestureStroke stroke, int numPoints) {
        final float increment = stroke.length / (numPoints - 1);
        int vectorLength = numPoints * 2;
        float[] vector = new float[vectorLength];
        float distanceSoFar = 0;
        float[] pts = stroke.points;
        float lstPointX = pts[0];
        float lstPointY = pts[1];
        int index = 0;
        float currentPointX = Float.MIN_VALUE;
        float currentPointY = Float.MIN_VALUE;
        vector[index] = lstPointX;
        index++;
        vector[index] = lstPointY;
        index++;
        int i = 0;
        int count = pts.length / 2;
        while (i < count) {
            if (currentPointX == Float.MIN_VALUE) {
                i++;
                if (i >= count) {
                    break;
                }
                currentPointX = pts[i * 2];
                currentPointY = pts[i * 2 + 1];
            }
            float deltaX = currentPointX - lstPointX;
            float deltaY = currentPointY - lstPointY;
            float distance = (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
            if (distanceSoFar + distance >= increment) {
                float ratio = (increment - distanceSoFar) / distance;
                float nx = lstPointX + ratio * deltaX;
                float ny = lstPointY + ratio * deltaY;
                vector[index] = nx;
                index++;
                vector[index] = ny;
                index++;
                lstPointX = nx;
                lstPointY = ny;
                distanceSoFar = 0;
            } else {
                lstPointX = currentPointX;
                lstPointY = currentPointY;
                currentPointX = Float.MIN_VALUE;
                currentPointY = Float.MIN_VALUE;
                distanceSoFar += distance;
            }
        }

        for (i = index; i < vectorLength; i += 2) {
            vector[i] = lstPointX;
            vector[i + 1] = lstPointY;
        }
        return vector;
    }

    /**
     * Calculates the centroid of a set of points.
     * 
     * @param points the points in the form of [x1, y1, x2, y2, ..., xn, yn]
     * @return the centroid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.132 -0500", hash_original_method = "DFDADD8A665EA1142AEA3E2588D88EDA", hash_generated_method = "D572B1EAE883F8EAD4A1BBC5FC3AC1EB")
    
static float[] computeCentroid(float[] points) {
        float centerX = 0;
        float centerY = 0;
        int count = points.length;
        for (int i = 0; i < count; i++) {
            centerX += points[i];
            i++;
            centerY += points[i];
        }
        float[] center = new float[2];
        center[0] = 2 * centerX / count;
        center[1] = 2 * centerY / count;

        return center;
    }

    /**
     * Calculates the variance-covariance matrix of a set of points.
     * 
     * @param points the points in the form of [x1, y1, x2, y2, ..., xn, yn]
     * @return the variance-covariance matrix
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.137 -0500", hash_original_method = "48A793410EC20AE25AD82C2AF4EE25D7", hash_generated_method = "A2CE7F5AE2378581AB4DB2D62947FD5F")
    
private static float[][] computeCoVariance(float[] points) {
        float[][] array = new float[2][2];
        array[0][0] = 0;
        array[0][1] = 0;
        array[1][0] = 0;
        array[1][1] = 0;
        int count = points.length;
        for (int i = 0; i < count; i++) {
            float x = points[i];
            i++;
            float y = points[i];
            array[0][0] += x * x;
            array[0][1] += x * y;
            array[1][0] = array[0][1];
            array[1][1] += y * y;
        }
        array[0][0] /= (count / 2);
        array[0][1] /= (count / 2);
        array[1][0] /= (count / 2);
        array[1][1] /= (count / 2);

        return array;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.141 -0500", hash_original_method = "02FBFA04883A09CFC23E696962F1BDC2", hash_generated_method = "5F227DCD8015551E8E59A6ACC5FE95F0")
    
static float computeTotalLength(float[] points) {
        float sum = 0;
        int count = points.length - 4;
        for (int i = 0; i < count; i += 2) {
            float dx = points[i + 2] - points[i];
            float dy = points[i + 3] - points[i + 1];
            sum += Math.sqrt(dx * dx + dy * dy);
        }
        return sum;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.145 -0500", hash_original_method = "6EC5F69F07FB249AAB57B30D01CFE064", hash_generated_method = "CBA4FA6B9B0ECC38A51FB5CF5443B9E3")
    
static float computeStraightness(float[] points) {
        float totalLen = computeTotalLength(points);
        float dx = points[2] - points[0];
        float dy = points[3] - points[1];
        return (float) Math.sqrt(dx * dx + dy * dy) / totalLen;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.149 -0500", hash_original_method = "60D05B89BFD66E52B9D0910D6ADD1A9B", hash_generated_method = "10F997CA331E83B708A6860DFB5DE411")
    
static float computeStraightness(float[] points, float totalLen) {
        float dx = points[2] - points[0];
        float dy = points[3] - points[1];
        return (float) Math.sqrt(dx * dx + dy * dy) / totalLen;
    }

    /**
     * Calculates the squared Euclidean distance between two vectors.
     * 
     * @param vector1
     * @param vector2
     * @return the distance
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.152 -0500", hash_original_method = "9932B280A007D916C3D0233ED3BF3F06", hash_generated_method = "E230E84E63B2CE60CCC0DA1455716A12")
    
static float squaredEuclideanDistance(float[] vector1, float[] vector2) {
        float squaredDistance = 0;
        int size = vector1.length;
        for (int i = 0; i < size; i++) {
            float difference = vector1[i] - vector2[i];
            squaredDistance += difference * difference;
        }
        return squaredDistance / size;
    }

    /**
     * Calculates the cosine distance between two instances.
     * 
     * @param vector1
     * @param vector2
     * @return the distance between 0 and Math.PI
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.156 -0500", hash_original_method = "AC6703CEA3D1C6D4141402E5D377F54E", hash_generated_method = "05566A625BFEF78DBF408CB613129282")
    
static float cosineDistance(float[] vector1, float[] vector2) {
        float sum = 0;
        int len = vector1.length;
        for (int i = 0; i < len; i++) {
            sum += vector1[i] * vector2[i];
        }
        return (float) Math.acos(sum);
    }
    
    /**
     * Calculates the "minimum" cosine distance between two instances.
     * 
     * @param vector1
     * @param vector2
     * @param numOrientations the maximum number of orientation allowed
     * @return the distance between the two instances (between 0 and Math.PI)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.160 -0500", hash_original_method = "73074AC3DAB22F190940DA30FB2EC678", hash_generated_method = "2276C89DCE0E416DDBB804AF7C9E52F7")
    
static float minimumCosineDistance(float[] vector1, float[] vector2, int numOrientations) {
        final int len = vector1.length;
        float a = 0;
        float b = 0;
        for (int i = 0; i < len; i += 2) {
            a += vector1[i] * vector2[i] + vector1[i + 1] * vector2[i + 1];
            b += vector1[i] * vector2[i + 1] - vector1[i + 1] * vector2[i];
        }
        if (a != 0) {
            final float tan = b/a;
            final double angle = Math.atan(tan);
            if (numOrientations > 2 && Math.abs(angle) >= Math.PI / numOrientations) {
                return (float) Math.acos(a);
            } else {
                final double cosine = Math.cos(angle);
                final double sine = cosine * tan; 
                return (float) Math.acos(a * cosine + b * sine);
            }
        } else {
            return (float) Math.PI / 2;
        }
    }

    /**
     * Computes an oriented, minimum bounding box of a set of points.
     * 
     * @param originalPoints
     * @return an oriented bounding box
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.164 -0500", hash_original_method = "7A337C125E2A540236207D4CECD80A2A", hash_generated_method = "6DEA7D44CF6655783252490F3FE401D2")
    
public static OrientedBoundingBox computeOrientedBoundingBox(ArrayList<GesturePoint> originalPoints) {
        final int count = originalPoints.size();
        float[] points = new float[count * 2];
        for (int i = 0; i < count; i++) {
            GesturePoint point = originalPoints.get(i);
            int index = i * 2;
            points[index] = point.x;
            points[index + 1] = point.y;
        }
        float[] meanVector = computeCentroid(points);
        return computeOrientedBoundingBox(points, meanVector);
    }

    /**
     * Computes an oriented, minimum bounding box of a set of points.
     * 
     * @param originalPoints
     * @return an oriented bounding box
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.168 -0500", hash_original_method = "41700754D59EF22B8871124AB8FA94BA", hash_generated_method = "0D9FD3044FA062824A8377544F1D29F5")
    
public static OrientedBoundingBox computeOrientedBoundingBox(float[] originalPoints) {
        int size = originalPoints.length;
        float[] points = new float[size];
        for (int i = 0; i < size; i++) {
            points[i] = originalPoints[i];
        }
        float[] meanVector = computeCentroid(points);
        return computeOrientedBoundingBox(points, meanVector);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.173 -0500", hash_original_method = "5B0D85D572EE610BF6D35AA62A77E92E", hash_generated_method = "FE299DC9A778AFAC737B9D8C78124347")
    
private static OrientedBoundingBox computeOrientedBoundingBox(float[] points, float[] centroid) {
        translate(points, -centroid[0], -centroid[1]);

        float[][] array = computeCoVariance(points);
        float[] targetVector = computeOrientation(array);

        float angle;
        if (targetVector[0] == 0 && targetVector[1] == 0) {
            angle = (float) -Math.PI/2;
        } else { // -PI<alpha<PI
            angle = (float) Math.atan2(targetVector[1], targetVector[0]);
            rotate(points, -angle);
        }

        float minx = Float.MAX_VALUE;
        float miny = Float.MAX_VALUE;
        float maxx = Float.MIN_VALUE;
        float maxy = Float.MIN_VALUE;
        int count = points.length;
        for (int i = 0; i < count; i++) {
            if (points[i] < minx) {
                minx = points[i];
            }
            if (points[i] > maxx) {
                maxx = points[i];
            }
            i++;
            if (points[i] < miny) {
                miny = points[i];
            }
            if (points[i] > maxy) {
                maxy = points[i];
            }
        }

        return new OrientedBoundingBox((float) (angle * 180 / Math.PI), centroid[0], centroid[1], maxx - minx, maxy - miny);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.178 -0500", hash_original_method = "C63B51F6028886E4E4754A50BCAFE776", hash_generated_method = "CA6A174CF6BDD847D32AFC336F4564FD")
    
private static float[] computeOrientation(float[][] covarianceMatrix) {
        float[] targetVector = new float[2];
        if (covarianceMatrix[0][1] == 0 || covarianceMatrix[1][0] == 0) {
            targetVector[0] = 1;
            targetVector[1] = 0;
        }

        float a = -covarianceMatrix[0][0] - covarianceMatrix[1][1];
        float b = covarianceMatrix[0][0] * covarianceMatrix[1][1] - covarianceMatrix[0][1]
                * covarianceMatrix[1][0];
        float value = a / 2;
        float rightside = (float) Math.sqrt(Math.pow(value, 2) - b);
        float lambda1 = -value + rightside;
        float lambda2 = -value - rightside;
        if (lambda1 == lambda2) {
            targetVector[0] = 0;
            targetVector[1] = 0;
        } else {
            float lambda = lambda1 > lambda2 ? lambda1 : lambda2;
            targetVector[0] = 1;
            targetVector[1] = (lambda - covarianceMatrix[0][0]) / covarianceMatrix[0][1];
        }
        return targetVector;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.182 -0500", hash_original_method = "578EF458F2D6855BA78C07E71E0F3496", hash_generated_method = "67C1E45CFEFCB83CA34A8E06429C81FD")
    
static float[] rotate(float[] points, float angle) {
        float cos = (float) Math.cos(angle);
        float sin = (float) Math.sin(angle);
        int size = points.length;
        for (int i = 0; i < size; i += 2) {
            float x = points[i] * cos - points[i + 1] * sin;
            float y = points[i] * sin + points[i + 1] * cos;
            points[i] = x;
            points[i + 1] = y;
        }
        return points;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.186 -0500", hash_original_method = "ED085039BB5B1C44865B45CD4D040608", hash_generated_method = "634599751CA418B8F7638600DB0EAFB3")
    
static float[] translate(float[] points, float dx, float dy) {
        int size = points.length;
        for (int i = 0; i < size; i += 2) {
            points[i] += dx;
            points[i + 1] += dy;
        }
        return points;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.190 -0500", hash_original_method = "EBEEC45DECB208A22716ECA0A3E2FD27", hash_generated_method = "F954438E871AFAF4EBA1948B1C418331")
    
static float[] scale(float[] points, float sx, float sy) {
        int size = points.length;
        for (int i = 0; i < size; i += 2) {
            points[i] *= sx;
            points[i + 1] *= sy;
        }
        return points;
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.101 -0500", hash_original_method = "924877739959A3756D2A4D30C807989C", hash_generated_method = "CA5CE4CFABAE9C71DD8D8BCA7CBC55D6")
    
private GestureUtils() {
    }
}
