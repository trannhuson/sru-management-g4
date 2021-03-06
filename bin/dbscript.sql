--create database srum_management
USE [srum_management]
GO
/****** Object:  Table [dbo].[attendance]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[attendance](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[create_time] [time](7) NULL,
	[created_date] [date] NULL,
	[end_time] [time](7) NULL,
	[note] [varchar](255) NULL,
	[type] [varchar](255) NULL,
	[id_person] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[certificate]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[certificate](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[code] [varchar](255) NULL,
	[completion_level] [varchar](255) NULL,
	[group_of] [varchar](255) NULL,
	[provider] [varchar](255) NULL,
	[final_grade] [varchar](255) NULL,
	[sub_group] [varchar](255) NULL,
	[trainee_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[class]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[class](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[active] [bit] NULL,
	[end_date] [datetime2](7) NULL,
	[name] [varchar](255) NULL,
	[note] [varchar](255) NULL,
	[open_date] [datetime2](7) NULL,
	[plan_count] [int] NULL,
	[status] [varchar](255) NULL,
	[type] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[feedback]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[feedback](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[consult_date] [datetime2](7) NULL,
	[id_training_objective] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[interview_result]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[interview_result](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[comment] [varchar](255) NULL,
	[date_interview] [nvarchar](200) NULL,
	[level] [int] NULL,
	[trainee_id] [bigint] NULL,
	[trainer_id] [bigint] NULL,
	[subject_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[issue]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[issue](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[created_date] [datetime2](7) NULL,
	[name] [varchar](255) NULL,
	[class_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[manager]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[manager](
	[id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[mistake]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[mistake](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[created_date] [datetime2](7) NULL,
	[description] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[note] [varchar](255) NULL,
	[trainee_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[question_feedback]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[question_feedback](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[course_likes] [varchar](255) NULL,
	[full_conveyed_content] [int] NULL,
	[good_instructors_teacher] [int] NULL,
	[improve_course] [varchar](255) NULL,
	[knowledgeable_teacher] [int] NULL,
	[satisfied] [int] NULL,
	[useful_course_for_me] [int] NULL,
	[id_feedback] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](60) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[score]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[score](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
	[value] [float] NULL,
	[trainee_id] [bigint] NULL,
	[training_object_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[solution]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[solution](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[created_date] [datetime2](7) NULL,
	[name_solution] [varchar](255) NULL,
	[issue_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[status]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[status](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[end_date] [datetime2](7) NULL,
	[learn_time] [float] NULL,
	[start_date] [datetime2](7) NULL,
	[type] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[trainee]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[trainee](
	[branch] [varchar](255) NULL,
	[faculty] [varchar](255) NULL,
	[image] [varchar](255) NULL,
	[note] [varchar](255) NULL,
	[parent_department] [varchar](255) NULL,
	[rec_interview_date] [datetime2](7) NULL,
	[rec_interview_status] [varchar](255) NULL,
	[university] [varchar](255) NULL,
	[id] [bigint] NOT NULL,
	[id_class] [bigint] NULL,
	[trainee_status] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[trainer]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[trainer](
	[id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[training_objective]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[training_objective](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[code] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[class_id] [bigint] NULL,
	[trainer_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_roles]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_roles](
	[user_id] [bigint] NOT NULL,
	[role_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC,
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 9/22/2021 10:31:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[account] [varchar](255) NULL,
	[active] [bit] NULL,
	[email] [varchar](255) NULL,
	[facebook] [varchar](255) NULL,
	[full_name] [varchar](255) NULL,
	[gender] [varchar](255) NULL,
	[password] [varchar](255) NULL,
	[phone_number] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[attendance] ON 

INSERT [dbo].[attendance] ([id], [create_time], [created_date], [end_time], [note], [type], [id_person]) VALUES (1, CAST(N'08:11:39' AS Time), CAST(N'2021-09-22' AS Date), CAST(N'18:13:04' AS Time), N'Ends later than 4:43', N'P', 114)
INSERT [dbo].[attendance] ([id], [create_time], [created_date], [end_time], [note], [type], [id_person]) VALUES (2, CAST(N'08:11:39' AS Time), CAST(N'2021-09-22' AS Date), CAST(N'18:13:04' AS Time), N'Ends later than 4:43', N'P', 115)
INSERT [dbo].[attendance] ([id], [create_time], [created_date], [end_time], [note], [type], [id_person]) VALUES (3, CAST(N'08:11:39' AS Time), CAST(N'2021-09-22' AS Date), CAST(N'18:13:04' AS Time), N'Ends later than 4:43', N'P', 116)
INSERT [dbo].[attendance] ([id], [create_time], [created_date], [end_time], [note], [type], [id_person]) VALUES (4, CAST(N'08:11:39' AS Time), CAST(N'2021-09-22' AS Date), CAST(N'18:13:04' AS Time), N'Ends later than 4:43', N'P', 117)
INSERT [dbo].[attendance] ([id], [create_time], [created_date], [end_time], [note], [type], [id_person]) VALUES (5, CAST(N'08:11:39' AS Time), CAST(N'2021-09-22' AS Date), CAST(N'18:13:04' AS Time), N'Ends later than 4:43', N'P', 118)
INSERT [dbo].[attendance] ([id], [create_time], [created_date], [end_time], [note], [type], [id_person]) VALUES (6, CAST(N'08:11:39' AS Time), CAST(N'2021-09-22' AS Date), CAST(N'18:13:04' AS Time), N'Ends later than 4:43', N'P', 119)
INSERT [dbo].[attendance] ([id], [create_time], [created_date], [end_time], [note], [type], [id_person]) VALUES (7, CAST(N'08:11:39' AS Time), CAST(N'2021-09-22' AS Date), CAST(N'18:13:04' AS Time), N'Ends later than 4:43', N'P', 120)
INSERT [dbo].[attendance] ([id], [create_time], [created_date], [end_time], [note], [type], [id_person]) VALUES (8, CAST(N'08:11:39' AS Time), CAST(N'2021-09-22' AS Date), CAST(N'18:13:04' AS Time), N'Ends later than 4:43', N'P', 121)
INSERT [dbo].[attendance] ([id], [create_time], [created_date], [end_time], [note], [type], [id_person]) VALUES (9, CAST(N'08:11:39' AS Time), CAST(N'2021-09-22' AS Date), CAST(N'18:13:04' AS Time), N'Ends later than 4:43', N'P', 122)
INSERT [dbo].[attendance] ([id], [create_time], [created_date], [end_time], [note], [type], [id_person]) VALUES (10, CAST(N'08:11:39' AS Time), CAST(N'2021-09-22' AS Date), CAST(N'18:13:04' AS Time), N'Ends later than 4:43', N'P', 124)
INSERT [dbo].[attendance] ([id], [create_time], [created_date], [end_time], [note], [type], [id_person]) VALUES (11, CAST(N'09:15:56' AS Time), CAST(N'2021-09-22' AS Date), CAST(N'17:28:03' AS Time), N'Ends later than 4:58', N'L', 123)
SET IDENTITY_INSERT [dbo].[attendance] OFF
GO
SET IDENTITY_INSERT [dbo].[class] ON 

INSERT [dbo].[class] ([id], [active], [end_date], [name], [note], [open_date], [plan_count], [status], [type]) VALUES (1, 1, CAST(N'2021-11-22T00:00:00.0000000' AS DateTime2), N'JAVA_01', NULL, CAST(N'2021-09-25T00:00:00.0000000' AS DateTime2), 18, N'Waiting', N'Fresher')
INSERT [dbo].[class] ([id], [active], [end_date], [name], [note], [open_date], [plan_count], [status], [type]) VALUES (2, 1, CAST(N'2021-12-22T00:00:00.0000000' AS DateTime2), N'JAVA_02', NULL, CAST(N'2021-09-18T00:00:00.0000000' AS DateTime2), 18, N'Waiting', N'Internship')
INSERT [dbo].[class] ([id], [active], [end_date], [name], [note], [open_date], [plan_count], [status], [type]) VALUES (3, 1, CAST(N'2021-12-22T00:00:00.0000000' AS DateTime2), N'FR_C#', NULL, CAST(N'2021-09-19T00:00:00.0000000' AS DateTime2), 19, N'Waiting', N'Fresher')
INSERT [dbo].[class] ([id], [active], [end_date], [name], [note], [open_date], [plan_count], [status], [type]) VALUES (4, 1, CAST(N'2021-12-22T00:00:00.0000000' AS DateTime2), N'ANDROID', NULL, CAST(N'2021-09-25T00:00:00.0000000' AS DateTime2), 20, N'Waiting', N'Internship')
SET IDENTITY_INSERT [dbo].[class] OFF
GO
SET IDENTITY_INSERT [dbo].[feedback] ON 

INSERT [dbo].[feedback] ([id], [consult_date], [id_training_objective]) VALUES (1, CAST(N'2021-09-22T22:12:11.0110000' AS DateTime2), 2)
INSERT [dbo].[feedback] ([id], [consult_date], [id_training_objective]) VALUES (2, CAST(N'2021-09-22T22:18:18.7080000' AS DateTime2), 6)
SET IDENTITY_INSERT [dbo].[feedback] OFF
GO
GO
SET IDENTITY_INSERT [dbo].[issue] ON 

INSERT [dbo].[issue] ([id], [created_date], [name], [class_id]) VALUES (1, CAST(N'2021-09-22T21:49:39.5880000' AS DateTime2), N'hoc. dot''', 1)
INSERT [dbo].[issue] ([id], [created_date], [name], [class_id]) VALUES (2, CAST(N'2021-09-22T21:49:55.4400000' AS DateTime2), N'muon gio', 1)
INSERT [dbo].[issue] ([id], [created_date], [name], [class_id]) VALUES (3, CAST(N'2021-09-22T21:50:18.2150000' AS DateTime2), N'luoi` hoc.', 1)
INSERT [dbo].[issue] ([id], [created_date], [name], [class_id]) VALUES (4, CAST(N'2021-09-22T21:51:50.3720000' AS DateTime2), N'di lam muon', 2)
INSERT [dbo].[issue] ([id], [created_date], [name], [class_id]) VALUES (5, CAST(N'2021-09-22T21:51:55.7190000' AS DateTime2), N'luoi hoc', 2)
INSERT [dbo].[issue] ([id], [created_date], [name], [class_id]) VALUES (6, CAST(N'2021-09-22T21:52:04.4830000' AS DateTime2), N'hoc kem''', 2)
INSERT [dbo].[issue] ([id], [created_date], [name], [class_id]) VALUES (7, CAST(N'2021-09-22T21:52:39.1400000' AS DateTime2), N'hoc kem''', 3)
INSERT [dbo].[issue] ([id], [created_date], [name], [class_id]) VALUES (8, CAST(N'2021-09-22T21:52:43.5400000' AS DateTime2), N'hoc. dot''', 3)
SET IDENTITY_INSERT [dbo].[issue] OFF
GO
INSERT [dbo].[manager] ([id]) VALUES (111)
GO
SET IDENTITY_INSERT [dbo].[mistake] ON 

INSERT [dbo].[mistake] ([id], [created_date], [description], [name], [note], [trainee_id]) VALUES (1, CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'dot', N'ngu', N'', 115)
INSERT [dbo].[mistake] ([id], [created_date], [description], [name], [note], [trainee_id]) VALUES (2, CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'non', N'ga', N'', 114)
INSERT [dbo].[mistake] ([id], [created_date], [description], [name], [note], [trainee_id]) VALUES (3, CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'nonnn', N'gaaaaaaaa', N'', 116)
INSERT [dbo].[mistake] ([id], [created_date], [description], [name], [note], [trainee_id]) VALUES (4, CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'nonnnnn', N'gaaaaaaaaaaaaa', N'', 117)
INSERT [dbo].[mistake] ([id], [created_date], [description], [name], [note], [trainee_id]) VALUES (5, CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'nonnnnnn', N'gaa', N'', 118)
INSERT [dbo].[mistake] ([id], [created_date], [description], [name], [note], [trainee_id]) VALUES (6, CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'nonnnnnnn', N'gaaaa', N'', 119)
INSERT [dbo].[mistake] ([id], [created_date], [description], [name], [note], [trainee_id]) VALUES (7, CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'nonnnnnnnnn', N'gaaa', N'', 120)
INSERT [dbo].[mistake] ([id], [created_date], [description], [name], [note], [trainee_id]) VALUES (8, CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'nonnnnnnnnnn', N'ga', N'', 121)
INSERT [dbo].[mistake] ([id], [created_date], [description], [name], [note], [trainee_id]) VALUES (9, CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'nonnnnnnnnnnnn', N'ga', N'', 122)
INSERT [dbo].[mistake] ([id], [created_date], [description], [name], [note], [trainee_id]) VALUES (10, CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'nonnnnnnnnnnnnn', N'ga', N'', 123)
INSERT [dbo].[mistake] ([id], [created_date], [description], [name], [note], [trainee_id]) VALUES (11, CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'nonnnnnnnnnnnnnnn', N'ga', N'', 124)
SET IDENTITY_INSERT [dbo].[mistake] OFF
GO
SET IDENTITY_INSERT [dbo].[question_feedback] ON 

INSERT [dbo].[question_feedback] ([id], [course_likes], [full_conveyed_content], [good_instructors_teacher], [improve_course], [knowledgeable_teacher], [satisfied], [useful_course_for_me], [id_feedback]) VALUES (1, N'ngon', 5, 5, N'ngon', 5, 5, 5, 1)
INSERT [dbo].[question_feedback] ([id], [course_likes], [full_conveyed_content], [good_instructors_teacher], [improve_course], [knowledgeable_teacher], [satisfied], [useful_course_for_me], [id_feedback]) VALUES (2, N'ngon', 5, 5, N'ngon', 5, 5, 5, 2)
SET IDENTITY_INSERT [dbo].[question_feedback] OFF
GO
SET IDENTITY_INSERT [dbo].[role] ON 

INSERT [dbo].[role] ([id], [name]) VALUES (1, N'ROLE_ADMIN')
INSERT [dbo].[role] ([id], [name]) VALUES (4, N'ROLE_DIRECTION')
INSERT [dbo].[role] ([id], [name]) VALUES (2, N'ROLE_TRAINEE')
INSERT [dbo].[role] ([id], [name]) VALUES (3, N'ROLE_TRAINER')
SET IDENTITY_INSERT [dbo].[role] OFF
GO
SET IDENTITY_INSERT [dbo].[score] ON 

INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (1, NULL, 10, 116, 1)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (2, NULL, 8, 117, 1)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (3, NULL, 9, 115, 1)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (4, NULL, 7, 115, 5)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (5, NULL, 6, 120, 4)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (6, NULL, 7, 118, 8)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (7, NULL, 8, 121, 8)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (8, NULL, 9, 122, 8)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (9, NULL, 9, 114, 2)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (10, NULL, 10, 119, 2)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (11, NULL, 9, 118, 3)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (12, NULL, 10, 121, 3)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (13, NULL, 7, 122, 3)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (14, NULL, 8, 115, 6)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (15, NULL, 8, 116, 6)
INSERT [dbo].[score] ([id], [name], [value], [trainee_id], [training_object_id]) VALUES (16, NULL, 8, 117, 6)
SET IDENTITY_INSERT [dbo].[score] OFF
GO
SET IDENTITY_INSERT [dbo].[solution] ON 

INSERT [dbo].[solution] ([id], [created_date], [name_solution], [issue_id]) VALUES (1, CAST(N'2021-09-22T21:50:41.5540000' AS DateTime2), N'check bai` moi~ ngay`', 3)
INSERT [dbo].[solution] ([id], [created_date], [name_solution], [issue_id]) VALUES (2, CAST(N'2021-09-22T21:50:53.4120000' AS DateTime2), N'phat. 50k', 2)
INSERT [dbo].[solution] ([id], [created_date], [name_solution], [issue_id]) VALUES (3, CAST(N'2021-09-22T21:51:21.8300000' AS DateTime2), N'check moi~ ngay`', 1)
INSERT [dbo].[solution] ([id], [created_date], [name_solution], [issue_id]) VALUES (4, CAST(N'2021-09-22T21:52:16.5290000' AS DateTime2), N'giao nhieu bai tap', 6)
INSERT [dbo].[solution] ([id], [created_date], [name_solution], [issue_id]) VALUES (5, CAST(N'2021-09-22T21:52:23.8130000' AS DateTime2), N'giao nhieu bai tap', 5)
INSERT [dbo].[solution] ([id], [created_date], [name_solution], [issue_id]) VALUES (6, CAST(N'2021-09-22T21:52:29.9590000' AS DateTime2), N'phat 100k', 4)
INSERT [dbo].[solution] ([id], [created_date], [name_solution], [issue_id]) VALUES (7, CAST(N'2021-09-22T21:52:52.0720000' AS DateTime2), N'cho nhieu` bai` tap.', 8)
INSERT [dbo].[solution] ([id], [created_date], [name_solution], [issue_id]) VALUES (8, CAST(N'2021-09-22T21:53:25.5400000' AS DateTime2), N'phat. 50k', 7)
SET IDENTITY_INSERT [dbo].[solution] OFF
GO
SET IDENTITY_INSERT [dbo].[status] ON 

INSERT [dbo].[status] ([id], [end_date], [learn_time], [start_date], [type]) VALUES (1, NULL, 3, NULL, N'Waiting')
INSERT [dbo].[status] ([id], [end_date], [learn_time], [start_date], [type]) VALUES (2, NULL, 3, NULL, N'Running')
INSERT [dbo].[status] ([id], [end_date], [learn_time], [start_date], [type]) VALUES (3, NULL, 3, NULL, N'Release')
SET IDENTITY_INSERT [dbo].[status] OFF
GO
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Waiting', N'FU', 114, 4, 2)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'FU', 115, 1, 2)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'FU', 116, 1, 1)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'FU', 117, 1, 2)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Waiting', N'FU', 118, 3, 2)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'UET', 119, 4, 2)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'PTIT', 120, 2, 1)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Waiting', N'FU', 121, 3, 2)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'FU', 122, 3, 2)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'FU', 123, 1, 1)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'FU', 124, 1, 1)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'FU', 125, 2, 1)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'FU', 126, 2, 1)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'FU', 127, 2, 1)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'FU', 128, 3, 1)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'FU', 129, 3, 1)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'FU', 130, 4, 1)
INSERT [dbo].[trainee] ([branch], [faculty], [image], [note], [parent_department], [rec_interview_date], [rec_interview_status], [university], [id], [id_class], [trainee_status]) VALUES (N'FS', N'FS', N'jira.PNG', N'', N'FF', CAST(N'2021-09-22T00:00:00.0000000' AS DateTime2), N'Success', N'FU', 131, 4, 1)
GO
INSERT [dbo].[trainer] ([id]) VALUES (112)
INSERT [dbo].[trainer] ([id]) VALUES (113)
GO
SET IDENTITY_INSERT [dbo].[training_objective] ON 

INSERT [dbo].[training_objective] ([id], [code], [name], [class_id], [trainer_id]) VALUES (1, N'DBI', N'Database', 1, 112)
INSERT [dbo].[training_objective] ([id], [code], [name], [class_id], [trainer_id]) VALUES (2, N'DBI', N'Database', 4, 112)
INSERT [dbo].[training_objective] ([id], [code], [name], [class_id], [trainer_id]) VALUES (3, N'DBI', N'Database', 3, 112)
INSERT [dbo].[training_objective] ([id], [code], [name], [class_id], [trainer_id]) VALUES (4, N'DBI', N'Database', 2, 112)
INSERT [dbo].[training_objective] ([id], [code], [name], [class_id], [trainer_id]) VALUES (5, N'JAVA', N'Java core', 1, 113)
INSERT [dbo].[training_objective] ([id], [code], [name], [class_id], [trainer_id]) VALUES (6, N'FEE', N'Frontend', 1, 112)
INSERT [dbo].[training_objective] ([id], [code], [name], [class_id], [trainer_id]) VALUES (7, N'FEE', N'Frontend', 2, 113)
INSERT [dbo].[training_objective] ([id], [code], [name], [class_id], [trainer_id]) VALUES (8, N'ORM', N'Hibernate', 3, 112)
SET IDENTITY_INSERT [dbo].[training_objective] OFF
GO
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (111, 1)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (112, 3)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (113, 3)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (114, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (115, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (116, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (117, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (118, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (119, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (120, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (121, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (122, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (123, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (124, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (125, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (126, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (127, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (128, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (129, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (130, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (131, 2)
GO
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (111, N'AnhLV', 0, N'anhlv@gmail.com', N'Anh Van', N'Anh Van', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (112, N'KhoeHD', 0, N'khoe@gmail.com', N'Ha Dinh Khoe', N'Ha Dinh Khoe', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456788')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (113, N'HoaBT2', 0, N'hoa@gmail.com', N'Bui Thanh Hoa', N'Bui Thanh Hoa', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'01234567899')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (114, N'hoangnv37', 1, N'trinhtan2000@gmail.com', N'', N'Nong Viet Hoang', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (115, N'tantt5', 1, N'trinhtan20000@gmail.com', N'', N'Trinh Thanh Tan', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (116, N'sontn', 1, N'sontn@gmail.com', N'', N'Tran Nhu Son', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (117, N'ninhdh', 1, N'ninhdh@gmail.com', N'', N'Do Huu Ninh', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (118, N'tantt6', 1, N'trinhtan200000@gmail.com', N'', N'Trinh Thanh Tan', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (119, N'hoangnv377', 1, N'trinhtan2000000@gmail.com', N'', N'Nong Viet Hoang', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (120, N'tantt8', 1, N'trinhtan20@gmail.com', N'', N'Trinh Thanh Tan', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (121, N'tantt', 1, N'trinhtan2@gmail.com', N'', N'Trinh Thanh Tan', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (122, N'tantt16', 1, N'trinhtan200000000@gmail.com', N'', N'Trinh Thanh Tan', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (123, N'tantt555', 1, N'tanreal151@gmail.com', N'', N'Trinh Thanh Tan', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (124, N'tantt5555', 1, N'tanreal1515@gmail.com', N'', N'Trinh Thanh Tan', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (125, N'tantt55555', 1, N'tanreal1511@gmail.com', N'', N'Trinh Thanh Tan', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (126, N'tantt555555', 1, N'tanreal15111@gmail.com', N'', N'Trinh Thanh Tan', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (127, N'tantt5554', 1, N'tanreal1551@gmail.com', N'', N'Trinh Thanh Tan', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (128, N'tantt55544', 1, N'tanreal151111@gmail.com', N'', N'Trinh Thanh Tan', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (129, N'tantt555444', 1, N'tanreal15111111@gmail.com', N'', N'Trinh Thanh Tan', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (130, N'tantt5556', 1, N'tanreal15166@gmail.com', N'', N'Trinh Thanh Tan', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
INSERT [dbo].[users] ([id], [account], [active], [email], [facebook], [full_name], [gender], [password], [phone_number]) VALUES (131, N'tantt55566', 1, N'tanreal15221@gmail.com', N'', N'Trinh Thanh Tan', N'Male', N'$2a$10$C68e2HIaS4nbMvxFeud/F.GhmDloAKHORJrNH9E2sZYyI7oBsk78.', N'0123456789')
SET IDENTITY_INSERT [dbo].[users] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_epk9im9l9q67xmwi4hbed25do]    Script Date: 9/22/2021 10:31:48 PM ******/
ALTER TABLE [dbo].[role] ADD  CONSTRAINT [UK_epk9im9l9q67xmwi4hbed25do] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_r2bdsy4yqtkpssr475ch00bdr]    Script Date: 9/22/2021 10:31:48 PM ******/
ALTER TABLE [dbo].[users] ADD  CONSTRAINT [UK_r2bdsy4yqtkpssr475ch00bdr] UNIQUE NONCLUSTERED 
(
	[account] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[users] ADD  DEFAULT ((1)) FOR [active]
GO
ALTER TABLE [dbo].[attendance]  WITH CHECK ADD  CONSTRAINT [FKg5pdjeabik25y067eevht8k7g] FOREIGN KEY([id_person])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[attendance] CHECK CONSTRAINT [FKg5pdjeabik25y067eevht8k7g]
GO
ALTER TABLE [dbo].[certificate]  WITH CHECK ADD  CONSTRAINT [FKany6b4p3u866pcl92fa142v1r] FOREIGN KEY([trainee_id])
REFERENCES [dbo].[trainee] ([id])
GO
ALTER TABLE [dbo].[certificate] CHECK CONSTRAINT [FKany6b4p3u866pcl92fa142v1r]
GO
ALTER TABLE [dbo].[feedback]  WITH CHECK ADD  CONSTRAINT [FKjbro4wi3xjbdt4xmsjf6mqiiy] FOREIGN KEY([id_training_objective])
REFERENCES [dbo].[training_objective] ([id])
GO
ALTER TABLE [dbo].[feedback] CHECK CONSTRAINT [FKjbro4wi3xjbdt4xmsjf6mqiiy]
GO
ALTER TABLE [dbo].[interview_result]  WITH CHECK ADD  CONSTRAINT [FK2g4xiy8m3kqjgm4ahn0pi2du4] FOREIGN KEY([trainer_id])
REFERENCES [dbo].[trainer] ([id])
GO
ALTER TABLE [dbo].[interview_result] CHECK CONSTRAINT [FK2g4xiy8m3kqjgm4ahn0pi2du4]
GO
ALTER TABLE [dbo].[interview_result]  WITH CHECK ADD  CONSTRAINT [FKo9lq0u2vxf61iyas2j03mrb2l] FOREIGN KEY([subject_id])
REFERENCES [dbo].[training_objective] ([id])
GO
ALTER TABLE [dbo].[interview_result] CHECK CONSTRAINT [FKo9lq0u2vxf61iyas2j03mrb2l]
GO
ALTER TABLE [dbo].[interview_result]  WITH CHECK ADD  CONSTRAINT [FKsofu2ud0p1sb2nkyd24n6l943] FOREIGN KEY([trainee_id])
REFERENCES [dbo].[trainee] ([id])
GO
ALTER TABLE [dbo].[interview_result] CHECK CONSTRAINT [FKsofu2ud0p1sb2nkyd24n6l943]
GO
ALTER TABLE [dbo].[issue]  WITH CHECK ADD  CONSTRAINT [FK8n64odpg055ts41c3kadw7300] FOREIGN KEY([class_id])
REFERENCES [dbo].[class] ([id])
GO
ALTER TABLE [dbo].[issue] CHECK CONSTRAINT [FK8n64odpg055ts41c3kadw7300]
GO
ALTER TABLE [dbo].[manager]  WITH CHECK ADD  CONSTRAINT [FKmqwhyh7lyvaoxegkx6nwj5u43] FOREIGN KEY([id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[manager] CHECK CONSTRAINT [FKmqwhyh7lyvaoxegkx6nwj5u43]
GO
ALTER TABLE [dbo].[mistake]  WITH CHECK ADD  CONSTRAINT [FK6r21qm99q5ffy8cjw7udlniq5] FOREIGN KEY([trainee_id])
REFERENCES [dbo].[trainee] ([id])
GO
ALTER TABLE [dbo].[mistake] CHECK CONSTRAINT [FK6r21qm99q5ffy8cjw7udlniq5]
GO
ALTER TABLE [dbo].[question_feedback]  WITH CHECK ADD  CONSTRAINT [FKbltrod1jkugnun0w450xg1esf] FOREIGN KEY([id_feedback])
REFERENCES [dbo].[feedback] ([id])
GO
ALTER TABLE [dbo].[question_feedback] CHECK CONSTRAINT [FKbltrod1jkugnun0w450xg1esf]
GO
ALTER TABLE [dbo].[score]  WITH CHECK ADD  CONSTRAINT [FK8fipjhk9v6sjkfqp0yrktnlq1] FOREIGN KEY([trainee_id])
REFERENCES [dbo].[trainee] ([id])
GO
ALTER TABLE [dbo].[score] CHECK CONSTRAINT [FK8fipjhk9v6sjkfqp0yrktnlq1]
GO
ALTER TABLE [dbo].[score]  WITH CHECK ADD  CONSTRAINT [FKj4vbye4pcdbjgp6eybi0lxj25] FOREIGN KEY([training_object_id])
REFERENCES [dbo].[training_objective] ([id])
GO
ALTER TABLE [dbo].[score] CHECK CONSTRAINT [FKj4vbye4pcdbjgp6eybi0lxj25]
GO
ALTER TABLE [dbo].[solution]  WITH CHECK ADD  CONSTRAINT [FKgvvxwtpysw24r4l26lpquokuc] FOREIGN KEY([issue_id])
REFERENCES [dbo].[issue] ([id])
GO
ALTER TABLE [dbo].[solution] CHECK CONSTRAINT [FKgvvxwtpysw24r4l26lpquokuc]
GO
ALTER TABLE [dbo].[trainee]  WITH CHECK ADD  CONSTRAINT [FK23k15qcmptaipw3cvalt2xi0m] FOREIGN KEY([trainee_status])
REFERENCES [dbo].[status] ([id])
GO
ALTER TABLE [dbo].[trainee] CHECK CONSTRAINT [FK23k15qcmptaipw3cvalt2xi0m]
GO
ALTER TABLE [dbo].[trainee]  WITH CHECK ADD  CONSTRAINT [FKpx9kccl4t64wtsi8geile7vwo] FOREIGN KEY([id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[trainee] CHECK CONSTRAINT [FKpx9kccl4t64wtsi8geile7vwo]
GO
ALTER TABLE [dbo].[trainee]  WITH CHECK ADD  CONSTRAINT [FKs35xg3yuqkghcmdrv8tgen1dd] FOREIGN KEY([id_class])
REFERENCES [dbo].[class] ([id])
GO
ALTER TABLE [dbo].[trainee] CHECK CONSTRAINT [FKs35xg3yuqkghcmdrv8tgen1dd]
GO
ALTER TABLE [dbo].[trainer]  WITH CHECK ADD  CONSTRAINT [FKd2hg6g09xsi5yyhtg5btyx13m] FOREIGN KEY([id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[trainer] CHECK CONSTRAINT [FKd2hg6g09xsi5yyhtg5btyx13m]
GO
ALTER TABLE [dbo].[training_objective]  WITH CHECK ADD  CONSTRAINT [FK8hdt1dyd0p1jwo7iar501ublq] FOREIGN KEY([trainer_id])
REFERENCES [dbo].[trainer] ([id])
GO
ALTER TABLE [dbo].[training_objective] CHECK CONSTRAINT [FK8hdt1dyd0p1jwo7iar501ublq]
GO
ALTER TABLE [dbo].[training_objective]  WITH CHECK ADD  CONSTRAINT [FKj5n6gyf9sweicfsoh6mvx4ntk] FOREIGN KEY([class_id])
REFERENCES [dbo].[class] ([id])
GO
ALTER TABLE [dbo].[training_objective] CHECK CONSTRAINT [FKj5n6gyf9sweicfsoh6mvx4ntk]
GO
ALTER TABLE [dbo].[user_roles]  WITH CHECK ADD  CONSTRAINT [FKhfh9dx7w3ubf1co1vdev94g3f] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[user_roles] CHECK CONSTRAINT [FKhfh9dx7w3ubf1co1vdev94g3f]
GO
ALTER TABLE [dbo].[user_roles]  WITH CHECK ADD  CONSTRAINT [FKrhfovtciq1l558cw6udg0h0d3] FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([id])
GO
ALTER TABLE [dbo].[user_roles] CHECK CONSTRAINT [FKrhfovtciq1l558cw6udg0h0d3]
GO
