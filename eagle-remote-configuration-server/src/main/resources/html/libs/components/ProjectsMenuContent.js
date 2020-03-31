var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var ProjectsMenuContent = function (_React$Component) {
	_inherits(ProjectsMenuContent, _React$Component);

	function ProjectsMenuContent(props) {
		_classCallCheck(this, ProjectsMenuContent);

		var _this = _possibleConstructorReturn(this, (ProjectsMenuContent.__proto__ || Object.getPrototypeOf(ProjectsMenuContent)).call(this, props));

		_this.state = { wrapped: true };

		_this.project_menu_content_block = React.createRef();
		return _this;
	}

	_createClass(ProjectsMenuContent, [{
		key: "wrapMenu",
		value: function wrapMenu() {
			this.setState({ wrapped: true });
			var blk = this.project_menu_content_block.current;
			blk.classList.toggle("unwrapped_projects_menu_content");
		}
	}, {
		key: "unwrapMenu",
		value: function unwrapMenu() {
			this.setState({ wrapped: false });
			var blk = this.project_menu_content_block.current;
			blk.classList.toggle("unwrapped_projects_menu_content");
		}
	}, {
		key: "render",
		value: function render() {

			var isWrapped = this.state.wrapped;
			var areProjectsExist = true;

			var no_projects_message = void 0;
			if (areProjectsExist) {
				no_projects_message = React.createElement(
					"p",
					{ style: projects_menu_content_no_content_msg },
					" ",
					this.props.NO_CONTENT_MSG,
					" "
				);
			}

			return React.createElement(
				"div",
				{ className: "projects_menu_content", ref: this.project_menu_content_block },
				no_projects_message,
				React.createElement(AddButton, { btn_id: "1", btn_title: this.props.content_add_btn_title })
			);
		}
	}]);

	return ProjectsMenuContent;
}(React.Component);