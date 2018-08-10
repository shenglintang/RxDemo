架构主要类说明
	BaseContract：契约基类
		BaseView V层基类
		BasePresenter：P层基类，与V层同步 声明周期，以及与V层绑定
	BasePresenterImpl：基类BasePresenter的实现类，封装声明周期与绑定V层
	CallBackListener：回调类，作用是将M层的数据传递给P层

