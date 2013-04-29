CREATE TABLE [dbo].[cstudio_SEQUENCE](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[namespace] [nvarchar](20) NOT NULL,
	[sql_generator] [bigint] NOT NULL,
	[step] [int] NOT NULL,
 CONSTRAINT [PK_cstudio_SEQUENCE] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY];

CREATE NONCLUSTERED INDEX [cstudio_sequence_namespace_idx] ON [dbo].[cstudio_SEQUENCE] ( [namespace] ASC )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY];