
	//Khởi tạo BannerSlider
	var bannerSlider = new Swiper(".banner-slider", {
		slidesPerView : 1,
		spaceBetween : 30,
		loop : true,
		pagination : {
			el : ".swiper-pagination",
			clickable : true,
		},
		navigation : {
			nextEl : ".swiper-button-next",
			prevEl : ".swiper-button-prev",
		},

	});

	// Khởi tạo CategorySlider
	var categorySlider = new Swiper(".category-slider", {
		slidesPerView : 5,
		spaceBetween : 30,
		grabCursor : true,
		// Khi màn hình nhỏ hơn kích thước nhỏ
		breakpoints : {
			0 : {
				slidesPerView : 2,
			},
			640 : {
				slidesPerView : 3,
				spaceBetween : 20,
			},
			800 : {
				slidesPerView : 4,
				spaceBetween : 20,
			},
			1024 : {
				slidesPerView : 5,
				spaceBetween : 20,
			},

		},
	});

	// KHởi tạo newReleasesSlider
	var newReleasesSlider = new Swiper(".new-releases-slider", {
		slidesPerView : 3,
		spaceBetween : 30,
		grabCursor : true,
		// Khi màn hình nhỏ hơn kích thước nhỏ
		breakpoints : {
			0 : {
				slidesPerView : 2,
			},
			750 : {
				slidesPerView : 2,
				spaceBetween : 30,
			},
			1024 : {
				slidesPerView : 3,
				spaceBetween : 40,
			},

		},
	});

// KHởi tạo sportSlider
	var sportSlider = new Swiper(".sport-slider", {
		slidesPerView : 5,
		spaceBetween : 30,
		grabCursor : true,
		// Khi màn hình nhỏ hơn kích thước nhỏ
		breakpoints : {
			0 : {
				slidesPerView : 2,
			},
			640 : {
				slidesPerView : 3,
				spaceBetween : 20,
			},
			800 : {
				slidesPerView : 4,
				spaceBetween : 20,
			},
			1024 : {
				slidesPerView : 5,
				spaceBetween : 20,
			},

		},
});


// KHởi tạo animeSlier
	var animeSlider = new Swiper(".anime-slider", {
		slidesPerView : 5,
		spaceBetween : 30,
		grabCursor : true,
		// Khi màn hình nhỏ hơn kích thước nhỏ
		breakpoints : {
			0 : {
				slidesPerView : 2,
			},
			640 : {
				slidesPerView : 3,
				spaceBetween : 20,
			},
			800 : {
				slidesPerView : 4,
				spaceBetween : 20,
			},
			1024 : {
				slidesPerView : 5,
				spaceBetween : 20,
			},

		},
});


// KHởi tạo animeSlier
	var channelSlider = new Swiper(".channel-slider", {
		slidesPerView : 5,
		spaceBetween : 30,
		grabCursor : true,
		// Khi màn hình nhỏ hơn kích thước nhỏ
		breakpoints : {
			0 : {
				slidesPerView : 2,
			},
			640 : {
				slidesPerView : 3,
				spaceBetween : 20,
			},
			800 : {
				slidesPerView : 4,
				spaceBetween : 20,
			},
			1024 : {
				slidesPerView : 5,
				spaceBetween : 20,
			},

		},
});

// KHởi tạo animeSlier
	var theatersSlider = new Swiper(".theaters-slider", {
		slidesPerView : 5,
		spaceBetween : 30,
		grabCursor : true,
		// Khi màn hình nhỏ hơn kích thước nhỏ
		breakpoints : {
			0 : {
				slidesPerView : 2,
			},
			640 : {
				slidesPerView : 3,
				spaceBetween : 20,
			},
			800 : {
				slidesPerView : 4,
				spaceBetween : 20,
			},
			1024 : {
				slidesPerView : 5,
				spaceBetween : 20,
			},

		},
});

// KHởi tạo animeSlier
	var podcastSlider = new Swiper(".podcast-slider", {
		slidesPerView : 5,
		spaceBetween : 30,
		grabCursor : true,
		// Khi màn hình nhỏ hơn kích thước nhỏ
		breakpoints : {
			0 : {
				slidesPerView : 2,
			},
			640 : {
				slidesPerView : 3,
				spaceBetween : 20,
			},
			800 : {
				slidesPerView : 4,
				spaceBetween : 20,
			},
			1024 : {
				slidesPerView : 5,
				spaceBetween : 20,
			},

		},
});



