LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := Demo_ndk
LOCAL_SRC_FILES := Demo_ndk.cpp

include $(BUILD_SHARED_LIBRARY)
