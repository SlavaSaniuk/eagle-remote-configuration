var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var AddButton = function (_React$Component) {
	_inherits(AddButton, _React$Component);

	function AddButton(props) {
		_classCallCheck(this, AddButton);

		var _this = _possibleConstructorReturn(this, (AddButton.__proto__ || Object.getPrototypeOf(AddButton)).call(this, props));

		_this.btn_div = React.createRef();
		return _this;
	}

	_createClass(AddButton, [{
		key: "getId",
		value: function getId(numeric_id) {
			return "add_button_" + numeric_id;
		}

		//Events handler

	}, {
		key: "onMouseEnter",
		value: function onMouseEnter() {

			var btn_div_classes = this.btn_div.current.classList;

			btn_div_classes.contains("animation_addButton_mouseLeave") && btn_div_classes.remove("animation_addButton_mouseLeave");

			setTimeout(function () {
				btn_div_classes.add("animation_addButton_mouseEnter");
			}, 0.1);
		}
	}, {
		key: "onMouseLeave",
		value: function onMouseLeave() {
			var btn_div_classes = this.btn_div.current.classList;

			btn_div_classes.contains("animation_addButton_mouseEnter") && btn_div_classes.remove("animation_addButton_mouseEnter");

			setTimeout(function () {
				btn_div_classes.add("animation_addButton_mouseLeave");
			}, 0.1);
		}
	}, {
		key: "render",
		value: function render() {
			var _this2 = this;

			return React.createElement(
				"div",
				{ id: this.getId(this.props.btn_id), style: Object.assign({}, add_btn_blk, add_projects_btn_size),
					ref: this.btn_div, onMouseEnter: function onMouseEnter() {
						return _this2.onMouseEnter();
					}, onMouseLeave: function onMouseLeave() {
						return _this2.onMouseLeave();
					} },
				React.createElement("img", { src: "img/add_button-min.png", style: add_projects_btn_img }),
				React.createElement(
					"p",
					{ style: add_projects_btn_text },
					" ",
					this.props.btn_title,
					" "
				)
			);
		}
	}]);

	return AddButton;
}(React.Component);